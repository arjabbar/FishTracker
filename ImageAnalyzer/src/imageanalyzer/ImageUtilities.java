/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageanalyzer;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author a10004323
 */
public class ImageUtilities {
    
    /****************************************************************************/
    //You'll notice that several grabFiles methods were created to give the method some flexibility
    //as far as the usage. They all work similarly
    /****************************************************************************/
    
    public static ArrayList<File> grabFiles(String startsWith, File directory)
    {
        //Make sure what you selected is a directory
        if (!directory.isDirectory()) {
            System.err.println("Non-directory referenced.");
            return null;
        }
        //The arraylist of Files that will be returned
        ArrayList<File> filteredFiles = new ArrayList<File>();
        //The list method returns a string array of filenames
        String[] filesInDirectory = directory.list();
        
        for (String file: filesInDirectory)
        {
            //Filter files that don't start with...
            if (file.startsWith(startsWith))
            {
                //And add it to the arraylist that will be returned
                filteredFiles.add(new File(file));
            }
        }
        return filteredFiles;
    }
    
    public static ArrayList<File> grabFiles(String startsWith, String endsWith, File directory)
    {
        if (!directory.isDirectory()) {
            System.err.println("Non-directory referenced.");
            return null;
        }
        ArrayList<File> filteredFiles = new ArrayList<File>();
        String[] filesInDirectory = directory.list();
        
        for (String file: filesInDirectory)
        {
            if (file.endsWith(endsWith) && file.startsWith(startsWith))
            {
                filteredFiles.add(new File(file));
            }
        }
        return filteredFiles;
    }
    
    public static ArrayList<File> grabFiles(File directory)
    {
        if (!directory.isDirectory()) {
            System.err.println("Non-directory referenced.");
            return null;
        }
        ArrayList<File> filteredFiles = new ArrayList<File>();
        String[] filesInDirectory = directory.list();
        
        for (String file: filesInDirectory)
        {
            
                filteredFiles.add(new File(file));
    
        }
        return filteredFiles;
    }
    
    public static void printFilesInArrayList(ArrayList<File> al)
    {
        for (int i = 0; i < al.size(); i++)
        {
            System.out.println(al.get(i).getName());
        }
    }
    
    public static void printArrayListContents(ArrayList al)
    {
        for (int i = 0; i < al.size(); i++)
        {
            System.out.println(al.get(i).toString());
        }
    }
    
    public static void printArray(Object[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i].toString());
        }
    }
    
    public static Image fileToImage(File filePath)
    {
        //Toolkit has a few useful functions, primarily getting images from files
        return Toolkit.getDefaultToolkit().getImage(filePath.getPath());
    }
    
    public static Image fileToImage(String filePath)
    {
        return Toolkit.getDefaultToolkit().getImage(filePath);
    }
    
    //This method does the same as above but with many files
    //Like a combination of the previous methods
    public static ArrayList<Image> grabImagesFromFiles(String prefix, File directory)
    {
        ArrayList<Image> images = new ArrayList<Image>();
        ArrayList<File> files = grabFiles(prefix, directory);
        for (File file: files)
        {
            images.add(fileToImage(new File(directory + "\\" + file)));
        }
        return images;
    }
    
    public static ArrayList<Image> grabImagesFromFiles(String prefix, String endsWith, File directory)
    {
        ArrayList<Image> images = new ArrayList<Image>();
        ArrayList<File> files = grabFiles(prefix, endsWith, directory);
        for (File file: files)
        {
            images.add(fileToImage(new File(directory + "\\" + file)));
        }
        return images;
    }
    
    public static ArrayList<Image> grabImagesFromFiles(File directory)
    {
        ArrayList<Image> images = new ArrayList<Image>();
        ArrayList<File> files = grabFiles(directory);
        for (File file: files)
        {
            images.add(fileToImage(new File(directory + "\\" + file)));
        }
        return images;
    }
    
    //Useless method because windows doesn't allow netbeans to modify files
    public static void changeFilenamesInDirectory(File directory, String startsWith, String newName, String extension)
    {
        DecimalFormat format = new DecimalFormat("###");
        ArrayList<File> files = grabFiles(startsWith, directory);
        for (int file = 0; file < files.size(); file++)
        {
            if (files.get(file).renameTo(new File(newName + format.format(file) + "." + extension)))
            {
                System.out.println("File renamed to " + (newName + format.format(file) + "." + extension));
            }
        }
    }
    
    //getScaledInstance allows resizing and returns a bufferedImage
    public static Image toImage(BufferedImage bi)
    {
        return bi.getScaledInstance(-1, -1, Image.SCALE_DEFAULT);
    }
    
    public static ArrayList<Image> bufferedImageListToImages(ArrayList<BufferedImage> images)
    {
        ArrayList<Image> imgList = new ArrayList<Image>(images.size());
        for (BufferedImage bi: images)
        {
            imgList.add(toImage(bi));
        }
        return imgList;
    }
    
    //Simple method used for debugging
    public static void showImage(Image image)
    {
        JFrame jf = new JFrame();
        jf.add(new JLabel(new ImageIcon(image)));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
    
}
