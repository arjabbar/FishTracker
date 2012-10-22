/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageanalyzer;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JLabel;


/**
 *
 * @author Abdur Jabbar <arjabbar@yahoo.com>
 */
public class FrameAnalyzer {
    
    public final int VID_LENGTH = 9;
    public int[][] frameCentroids = null;
    public int[][] renderedImageArray = null;
    public int[] data = null;
    public ImageAnalyzer ia = new ImageAnalyzer();
    public ArrayList<Image> frames = new ArrayList<Image>();
    public ArrayList<BufferedImage> renderedFrames;
    public ArrayList<Image> renderedImages;
    public int width_of_images;
    public int hieght_of_images;
    
    //There are several ways of starting a FrameAnalyzer depending on if 
    //you want the entire directory or select files
    public FrameAnalyzer(File directory) {
        
        frames = ImageUtilities.grabImagesFromFiles(directory);
        frameCentroids = new int[frames.size()][2];
        data = new int[frames.size()];
    }
    
    public FrameAnalyzer(File directory,String startsWith) {
        
        frames = ImageUtilities.grabImagesFromFiles(startsWith, directory);
        frameCentroids = new int[frames.size()][2];
        data = new int[frames.size()];
    }
    
    public FrameAnalyzer(File directory,String startsWith, String endsWith) {
        
        frames = ImageUtilities.grabImagesFromFiles(startsWith, endsWith, directory);
        frameCentroids = new int[frames.size()][2];
        data = new int[frames.size()];
    }
    
    //Was used but found out it didn't render the images accurately and ate memory
    public void renderFrames(int threshold, int rgbValue)
    {
        System.out.print("Rendering frames...");
        BufferedImage thisFrame;
        for (Image frame: frames)
        {
            System.out.print(".");
            thisFrame = ia.toBufferedImage(frame);
            renderedFrames.add(ia.highlightedSubject(rgbValue, threshold, thisFrame));
        }
        
        renderedImages = ImageUtilities.bufferedImageListToImages(renderedFrames);
        System.out.println("Frames rendered!");
    }
    
    //Looks at every image and creates a rendered 2D array
    //Only pixels of the rgb value are used in calculating the average location of the target
    public void createRenderedFrameArrays(int red, int green, int blue, int redThreshold, int blueThreshold, int greenThreshold) throws InterruptedException
    {
        
        for (int frame = 0; frame < frames.size(); frame++) {
            renderedImageArray = ia.highlightedSubjectArray(red, green, blue, redThreshold, blueThreshold, greenThreshold, ia.toBufferedImage(frames.get(frame)));
            frameCentroids[frame][0] = ImageAnalyzer.averageValue(renderedImageArray[0]);
            frameCentroids[frame][1] = ImageAnalyzer.averageValue(renderedImageArray[1]);
            System.out.println("Rendered Frame " + (frame + 1) + " of " + frames.size());
        }
    }
    
    //Same as above but can output to a GUI
    public void createRenderedFrameArrays(JLabel jl, int red, int green, int blue, int redThreshold, int blueThreshold, int greenThreshold) throws InterruptedException
    {
        Image img;
        for (int frame = 0; frame < frames.size(); frame++) {
            img = frames.get(frame);
            renderedImageArray = ia.highlightedSubjectArray(red, green, blue, redThreshold, blueThreshold, greenThreshold, ia.toBufferedImage(img));
            frameCentroids[frame][0] = ImageAnalyzer.averageValue(renderedImageArray[0]);
            frameCentroids[frame][1] = ImageAnalyzer.averageValue(renderedImageArray[1]);
            jl.setText("Rendered Frame " + (frame + 1) + " of " + frames.size());
            
        }
    }
    
    public void printCentroidList()
    {
        for (int frame = 0; frame < this.frameCentroids.length; frame++)
        {
            for (int centroid = 0; centroid < this.frameCentroids[frame].length; centroid++)
            {
                System.out.print(frameCentroids[frame][centroid] + "\t");
            }
            System.out.println();
        }
    }
 
    public int averagePixelChange()
    {
        int sum = 0;
        for (int frame = 0; frame < frames.size(); frame++)
        {
            try {
                sum += ia.DifferentPixels(frames.get(frame), frames.get(frame + 1));
                data[frame] = ia.DifferentPixels(frames.get(frame), frames.get(frame + 1));
            } catch (InterruptedException ex) {
                
            } catch (NegativeArraySizeException nas) {
                
            } catch (Exception ai) {
                
            }
            
        }
        return sum /= frames.size();
    }
    
    public Point locationAtTime(int sec)
    {
        int loc = (frames.size() * sec) / VID_LENGTH;
        return new Point(frameCentroids[loc][0], frameCentroids[loc][1]);
    }
    
    public int timeWithMostChange()
    {
        int biggestChange = 0;
        int time = 0;
        for (int x = 0; x < data.length; x++)
        {
            if (data[x]>biggestChange)
            {
                biggestChange = x;
                time = x;
            }
        }
        return time / (frames.size() / VID_LENGTH);
    }
    
    public static <E> void prnt(E o)
    {
        System.out.println(o);
    }
    
}
