
package imageanalyzer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Abdur Jabbar <arjabbar@yahoo.com>
 */
public class CompareImage {
    
    //Class used for testing methods
    
    public static Color fish = new Color(136, 54, 40);
    public static ImageAnalyzer ia = new ImageAnalyzer();
    
    public static void main(String[] args) {
        try {
            int threshold = 1000;
            File dir = new File(".\\Reception");
            ArrayList<Image> fishFrames = ImageUtilities.grabImagesFromFiles("test", dir);
            FrameAnalyzer fa = new FrameAnalyzer(dir, "test");
            
            fa.createRenderedFrameArrays(fish.getRed(), fish.getGreen(), fish.getBlue(), 20, 20, 20);
            Image goldfish = fa.frames.get(0);       
            ImageUtilities.showImage(goldfish);
            fa.printCentroidList();
            BufferedImage highlightedSubject = ia.highlightedSubject(fish.getRed(), fish.getGreen(), fish.getBlue(), 40, 40, 20, ia.toBufferedImage(goldfish));
            JFrame jf = new JFrame("Fish");
            jf.add(new JLabel(new ImageIcon(ImageUtilities.toImage(highlightedSubject))));
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.pack();
            jf.setVisible(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(CompareImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        

        
        
    }
    
    
    
}
