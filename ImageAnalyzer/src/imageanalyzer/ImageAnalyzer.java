/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageanalyzer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 * @date 
 * @author Abdur Jabbar <arjabbar@yahoo.com>
 * The 'toBuffered' and 'hasAlpha' methods were pulled from http://www.exampledepot.com/egs/java.awt.image/image2buf.html
 */
public class ImageAnalyzer{
    
    //This class is used more like a Utility class, so no parameters
    public ImageAnalyzer() {
    }

    //Returns an 2D int array of an image
    //Each index in the array represents a pixel's rgb value
    public int[][] imageTo2DArray(BufferedImage image) {
        int[][] rgbArray = new int[image.getWidth()][image.getHeight()];

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                rgbArray[x][y] = image.getRGB(x, y);
            }
        }
        return rgbArray;
    }
    
    public int[][][] imageTo3DArray(BufferedImage image) {
        int[][][] rgbArray = new int[image.getWidth()][image.getHeight()][4];
        int[][] imgArray = imageTo2DArray(image);

        for (int z = 0; z < 3; z++) {
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    rgbArray[x][y][z] = rgbValues(imgArray[x][y])[z];
                }
                
            }
            
        }
        return rgbArray;   
    }

    //Returns the amount of pixels that are not exactly identical between images
    //Sort of useless unless you have extremely similar images
    public int DifferentPixels(Image img1, Image img2) throws InterruptedException {
        int[] pix1, pix2;
        int numDifferent = 0;
        pix1 = new int[(img1.getHeight(null) * img1.getWidth(null))];
        pix2 = new int[(img2.getHeight(null) * img2.getWidth(null))];
        //Pixelgrabber can be used to grab info about individual pixels from an image
        //This is alot easier with a bufferedImage and isn't necessary except for images
        PixelGrabber pg1 = new PixelGrabber(img1, 0, 0, -1, -1, false);
        PixelGrabber pg2 = new PixelGrabber(img2, 0, 0, -1, -1, false);
        pg1.grabPixels();
        pg2.grabPixels();
        pix1 = (int[]) pg1.getPixels();
        pix2 = (int[]) pg2.getPixels();

        for (int p = 0; p < pix1.length; p++) {
            if (pix1[p] != pix2[p]) {
                numDifferent++;
            }
        }
        return numDifferent;
    }
    
    public int mostCommonRGBvalue(BufferedImage image)
    {
        int[] rgb = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, 0);
        int size = image.getHeight() * image.getWidth();
        int[][] values = new int[size][2];
        int slot = 0, count = 1, commonValue = 0, maxCount = 0;
        Arrays.sort(rgb);
        
        for (int i: rgb)
        {
            if (slot==i) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                commonValue = i;
            }
            slot = i;
        }   
        return commonValue;
    }
    
    //Used for looking through arrays searching for a particular int
    public boolean containsInt(int num, int[] list)
    {
        for (int i:list)
        {
            if (i==num) {
                return true;
            }
        }
        return false;
    }
    
    public void print2DArray (int[][] array) {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                System.out.print(array[y][x] + "\t");
            }
            System.out.println();
        }
    }
    
    public String RGBValue(int value)
    {
        int [] rgbArray = rgbValues(value);
        return ("R:" + rgbArray[1] + " G:" + rgbArray[2] + " B:" + rgbArray[3]);
    }
    
    public int getSingleRGBValue(BufferedImage image, int x, int y, int value)
    {
        return (rgbValues(image.getRGB(x, y))[value]);
    }
    
    public int [][] getAlphaRGBValues(BufferedImage image, int value)
    {
        int [][] array = new int [image.getWidth()][image.getHeight()];
        
        int [][][] rgb3DArray = imageTo3DArray(image);
        
        for (int y = 0; y < image.getHeight(); y++)
        {
            for (int x = 0; x < image.getWidth(); x++)
            {
                array[x][y] = rgb3DArray[x][y][value];
            }
        }
        return array;
    }

    public void printBWTarget(Image img, char color, char nonColor) {
        BufferedImage bi = toBufferedImage(img);
        int[][] imgArray = imageTo2DArray(bi);

        for (int y = 0; y < imgArray.length; y++) {
            for (int x = 0; x < imgArray[y].length; x++) {
                if (imgArray[x][y] != 0) {
                    System.out.print(color);
                } else {
                    System.out.print(nonColor);
                }
            }
            System.out.println();
        }
    }
    
    public void printTarget(Image img, char a, char b)    
    {
        BufferedImage bi = toBufferedImage(img);
        int[][] imgArray = imageTo2DArray(bi);
        int avg = averageRGBValue(bi);

        for (int y = 0; y < imgArray.length; y++) {
            for (int x = 0; x < imgArray[y].length; x++) {
                if (Math.abs(imgArray[x][y]) > avg)
                {
                    System.out.print(a);
                } else {
                    System.out.print(b);
                }
            }
            System.out.println();
        }
    }

    public int[] rgbValues(int rgb) {
        int alpha = (rgb >>> 24) & 0xFF;
        int red = (rgb >>> 16) & 0xFF;
        int green = (rgb >>> 8) & 0xFF;
        int blue = (rgb) & 0xFF;
        int[] rgbValues = {alpha, red, green, blue};
        return rgbValues;
    }
    
    public int averageRGBValue(BufferedImage image)
    {
         
        int sum = 0;
        int pixels = 0;
        int [][] array = imageTo2DArray(image);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                sum+=array[x][y];
                pixels++;
            }
        }
        return (sum/pixels);
    }
    
    public int averageSingleRGBValue(BufferedImage image, int value)
    {
        int sum = 0;
        int pixels = 0;
        int [][] array = getAlphaRGBValues(image, value);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                sum+=getSingleRGBValue(image, x, y, value);
                pixels++;
            }
        }
        return (sum/pixels);
    }
    
    public String pixelDataToString(int[] pixel)
    {
        String pixelString = "";
        for (int i : pixel)
        {
            pixelString = (String.valueOf(i) + " ");
        }
        return pixelString;
    }
    
    //Was my attempt to use my k-means clustering program to track, not actually used
    public void createImageClusterFile(BufferedImage image, File file) throws IOException
    {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        int[][] imageArray = imageTo2DArray(image);
        int[] rgbValues = new int[4];
        int points = image.getWidth() * image.getHeight();
        int attributes = 6;
        
        bw.write("" + points + " " + attributes + "\r");
        
        for (int y = 0; y < image.getHeight(); y++)
        {
            
            for (int x = 0; x < image.getWidth(); x++)
            {
                rgbValues = rgbValues(imageArray[x][y]);
                bw.write("" + x + " " + y + " ");
                bw.write(rgbValues[0] + " " + rgbValues[1] + " " + rgbValues[2] + " " + rgbValues[3] + "\r");
            }
        }
        bw.close();
        System.out.println("Image width = " + image.getWidth() + "\n" + 
                "Image Hieght = " + image.getHeight() + "\n" + 
                "Image Size = " + (image.getWidth() * image.getHeight()) + "\n" + 
                "Array size = " + imageArray.length + " by " + imageArray[0].length + " by " + rgbValues.length);
    }
    
    //Returns a buffered image of the subject highlighted with black pixels on a white background
    public BufferedImage highlightedSubject(int targetRGBValue, int threshold, BufferedImage image)
    {
        BufferedImage selection = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int[][] imageArray = imageTo2DArray(image);
        for (int y = 0; y < image.getHeight(); y++)
        {
            for (int x = 0; x < image.getWidth(); x++)
            {
                //If the pixel in question is close to the rgb value paint a black pixel, otherwise white
                if ((imageArray[x][y] > targetRGBValue - threshold) && (imageArray[x][y] < targetRGBValue + threshold))
                {
                    selection.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    selection.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        return selection;
    }
    
    //Does the same as above but is way more precise
    public BufferedImage highlightedSubject(int red, int green, int blue, int redThreshold, int blueThreshold, int greenThreshold, BufferedImage image)
    {
        BufferedImage selection = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int[][] imageArray = imageTo2DArray(image);
        for (int y = 0; y < image.getHeight(); y++)
        {
            for (int x = 0; x < image.getWidth(); x++)
            {
                Color rgb = new Color(imageArray[x][y]);
                if (((rgb.getRed() > red - redThreshold) && (rgb.getRed() < red + redThreshold)) &&
                        ((rgb.getGreen() > green - greenThreshold) && (rgb.getGreen() < green + greenThreshold)) &&
                        ((rgb.getBlue() > blue - blueThreshold) && (rgb.getBlue() < blue + blueThreshold)))
                {
                    selection.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    selection.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        return selection;
    }
    
    //Does the same as above but returns a 2D int array representing pixel locations with
    //the rgb values passed. If that pixel doesn't meet the criteria then the index is filled
    //with a 0. 
    public int[][] highlightedSubjectArray(int red, int green, int blue, int redThreshold, int blueThreshold, int greenThreshold, BufferedImage image)
    {
        int[][] hsArray = new int[2][image.getWidth() * image.getHeight()];
        int[][] imageArray = imageTo2DArray(image);
        int pixel = 0;
        for (int y = 0; y < image.getHeight(); y++)
        {
            for (int x = 0; x < image.getWidth(); x++)
            {
                Color rgb = new Color(imageArray[x][y]);
                if (((rgb.getRed() > red - redThreshold) && (rgb.getRed() < red + redThreshold)) &&
                        ((rgb.getGreen() > green - greenThreshold) && (rgb.getGreen() < green + greenThreshold)) &&
                        ((rgb.getBlue() > blue - blueThreshold) && (rgb.getBlue() < blue + blueThreshold)))
                {
                    hsArray[0][pixel] = x;
                    hsArray[1][pixel] = y;
                } else {
                    hsArray[0][pixel] = 0;
                    hsArray[1][pixel] = 0;
                }
                pixel++;
            }
        }
        return hsArray;
    }
    
    //Used to find the central X Y value of the above method
    public static int averageValue(int[] array)
    {
        int sum = 0;
        int count = 0;
        for (int x = 0; x < array.length; x++)
        {
            if (array[x]!=0) {
                sum += array[x];
                count++;
            }
            
        }
        int avg = sum / count;
        return avg;
    }

    //The 2 later methods are used to convert images to buffered images
    public boolean hasAlpha(Image image) {
        // If buffered image, the color model is readily available
        if (image instanceof BufferedImage) {
            BufferedImage bimage = (BufferedImage) image;
            return bimage.getColorModel().hasAlpha();
        }

        // Use a pixel grabber to retrieve the image's color model;
        // grabbing a single pixel is usually sufficient
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
        }

        // Get the image's color model
        ColorModel cm = pg.getColorModel();
        return cm.hasAlpha();
    }

    public BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();

        // Determine if the image has transparent pixels; for this method's
        // implementation, see Determining If an Image Has Transparent Pixels
        boolean hasAlpha = hasAlpha(image);

        // Create a buffered image with a format that's compatible with the screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }

            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(
                    image.getWidth(null), image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }

        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }

        // Copy image to buffered image
        Graphics g = bimage.createGraphics();

        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bimage;
    }
}
