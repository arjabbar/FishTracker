
/*
 * FishAnalyzerApp.java
 *
 * Created on Apr 28, 2012, 12:55:42 PM
 */
package fishanalyzer;

import imageanalyzer.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import html.HTMLUtilities;

/**
 *
 * @author Abdur Jabbar <arjabbar@yahoo.com>
 */
public class FishAnalyzerApp extends javax.swing.JFrame {

    String results;                         //The string that holds the html file of data
    Desktop dt = Desktop.getDesktop();      //The desktop class is used to open files in java
    FrameAnalyzer fa;                       //The other classes I wrote
    ImageAnalyzer ia = new ImageAnalyzer();
    Image renderedImage;                    //The first frame that shows the subject being tracked
    File dir;                               //The directory you will select
    final Color fish = new Color(136, 54, 40);    //The color of the fish, used only for testing
    int delay = 50;                         //The rate at which the frames are updated
    int t = 0;                              //Keeps track of how many times the timer fired
    boolean updating;                       //Allows for certain operations to be turned on and off
    
    /****************************************************************************/
    //This timer keeps updating the frames in the arraylist to give the look of a movie.
    //It also updates box2 or the rendered image while you're changing the threshold
    //and RGB values
    /****************************************************************************/
    Timer timer = new Timer(delay, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            Image frame = fa.frames.get(t % fa.frames.size());
            renderedImage = ia.highlightedSubject(redValue.getValue(),
                    greenValue.getValue(), blueValue.getValue(), redThreshold.getValue(),
                    greenThreshold.getValue(), blueThreshold.getValue(), ia.toBufferedImage(fa.frames.get(0)));
            box1.setIcon(new ImageIcon(frame.getScaledInstance(360, 240, Image.SCALE_FAST)));
            box1.repaint();
            box2.setIcon(new ImageIcon(renderedImage));
            box2.repaint();
            t++;

        }
    });

    /** Creates new form FishAnalyzerApp */
    public FishAnalyzerApp() {

        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        box1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        redValue = new javax.swing.JSlider();
        greenValue = new javax.swing.JSlider();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        blueValue = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        box2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        redThreshold = new javax.swing.JSlider();
        blueThreshold = new javax.swing.JSlider();
        greenThreshold = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        trackButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        xLoc = new javax.swing.JLabel();
        yLoc = new javax.swing.JLabel();
        loadLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        framesLabel = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        speedSlider = new javax.swing.JSlider();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        box1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        jLabel10.setText("Target Value");

        redValue.setMajorTickSpacing(50);
        redValue.setMaximum(255);
        redValue.setMinorTickSpacing(10);
        redValue.setPaintLabels(true);
        redValue.setPaintTicks(true);
        redValue.setSnapToTicks(true);

        greenValue.setMajorTickSpacing(50);
        greenValue.setMaximum(255);
        greenValue.setMinorTickSpacing(10);
        greenValue.setPaintLabels(true);
        greenValue.setPaintTicks(true);

        jLabel9.setText("Red");

        jLabel8.setText("Green");

        blueValue.setMajorTickSpacing(50);
        blueValue.setMaximum(255);
        blueValue.setMinorTickSpacing(10);
        blueValue.setPaintLabels(true);
        blueValue.setPaintTicks(true);

        jLabel7.setText("Blue");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(redValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(greenValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blueValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addGap(70, 70, 70)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greenValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(blueValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        box2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        jLabel3.setText("Threshold");

        redThreshold.setMajorTickSpacing(10);
        redThreshold.setMaximum(50);
        redThreshold.setMinorTickSpacing(5);
        redThreshold.setPaintLabels(true);
        redThreshold.setPaintTicks(true);
        redThreshold.setValue(25);

        blueThreshold.setMajorTickSpacing(10);
        blueThreshold.setMaximum(50);
        blueThreshold.setMinorTickSpacing(5);
        blueThreshold.setPaintLabels(true);
        blueThreshold.setPaintTicks(true);
        blueThreshold.setValue(25);

        greenThreshold.setMajorTickSpacing(10);
        greenThreshold.setMaximum(50);
        greenThreshold.setMinorTickSpacing(5);
        greenThreshold.setPaintLabels(true);
        greenThreshold.setPaintTicks(true);
        greenThreshold.setValue(25);

        jLabel1.setText("Red");

        jLabel2.setText("Green");

        jLabel6.setText("Blue");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(redThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(greenThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blueThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greenThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(blueThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        trackButton.setFont(new java.awt.Font("Gommogravure", 0, 18));
        trackButton.setText("<html><p style = \"color:red;\">Track</p></html>");
        trackButton.setEnabled(false);
        trackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("X :");

        jLabel12.setText("Y :");

        xLoc.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        yLoc.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel14.setText("# of Frames :");

        framesLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(xLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(yLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(framesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                .addComponent(trackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(xLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(yLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(framesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exitButton)
                            .addComponent(loadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jProgressBar1.setOpaque(true);
        jProgressBar1.setStringPainted(true);

        speedSlider.setMaximum(200);
        speedSlider.setMinimum(1);
        speedSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        speedSlider.setSnapToTicks(true);
        speedSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });

        jLabel13.setText("Speed");

        jMenu1.setText("File");

        jMenuItem2.setText("Open...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tools");

        jMenuItem3.setText("Save as html file");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        /****************************************************************************/
        //Once you click on open, the selected directory will be sorted through looking for
        //files that start with anything or "" and end with ".jpg". Then the track button is
        //enabled that way you can't press it without loading frames.
        /****************************************************************************/
        
        JFileChooser jfc = new JFileChooser(new File(".\\"));
        jfc.setDialogTitle("Choose directory of Images");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showOpenDialog(jLabel1);
        dir = jfc.getSelectedFile();
        fa = new FrameAnalyzer(dir, "", "jpg");
        timer.start();
        framesLabel.setText("" + fa.frames.size());
        trackButton.setEnabled(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void trackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackButtonActionPerformed

        /****************************************************************************/
        //It is critical to use a separate thread to handle the processing of the frames
        //because it is such an intensive process. If a thread wasn't used, the entire program
        //would freeze until the entire operation was over.
        /****************************************************************************/
        Runnable renderArray = new Runnable() {
            @Override
            public void run() {
                updating = true;

                redThreshold.setEnabled(false);
                redValue.setEnabled(false);
                greenThreshold.setEnabled(false);
                greenValue.setEnabled(false);
                blueThreshold.setEnabled(false);
                blueValue.setEnabled(false);
                jProgressBar1.setMaximum(fa.frames.size());

                /****************************************************************************/
                //This loops sorts through each frame, gets the renderedImage represented by int[][]arrays
                //and finds the average location of the blackened pixels and stores it in a separate int[][] array
                //Finally you'll see that after each frame the progress bar is updated and incremented
                /****************************************************************************/
                for (int frame = 0; frame < fa.frames.size(); frame++) {

                    fa.renderedImageArray = ia.highlightedSubjectArray(redValue.getValue(), greenValue.getValue(),
                            blueValue.getValue(), redThreshold.getValue(), blueThreshold.getValue(),
                            greenThreshold.getValue(), ia.toBufferedImage(fa.frames.get(frame)));

                    fa.frameCentroids[frame][0] = ImageAnalyzer.averageValue(fa.renderedImageArray[0]);
                    fa.frameCentroids[frame][1] = ImageAnalyzer.averageValue(fa.renderedImageArray[1]);
                    loadLabel.setText("Rendered Frame " + (frame + 1) + " of " + fa.frames.size());
                    jProgressBar1.setValue(frame + 1);
                }

                while (updating) {
                    int centX = fa.frameCentroids[t % fa.frameCentroids.length][0];
                    int centY = fa.frameCentroids[t % fa.frameCentroids.length][1];

                    xLoc.setText(Integer.toString(centX));
                    yLoc.setText(Integer.toString(centY));

                }
                trackButton.setEnabled(false);
            }

            int totalMovement(int[] array) {
                int sum = 0;
                for (int num : array) {
                    sum += num;
                }
                return sum;
            }
        };

        Thread r = new Thread(renderArray);
        r.start();

    }//GEN-LAST:event_trackButtonActionPerformed

    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        timer.setDelay(speedSlider.getValue());
    }//GEN-LAST:event_speedSliderStateChanged

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        /****************************************************************************/
        //When the reset button is hit, everything goes back to it's original state.
        //updating keeps the X and Y locations refreshing in a separate thread
        /****************************************************************************/
        
        updating = false;
        timer.stop();
        trackButton.setEnabled(false);
        fa = null;
        box1.setIcon(null);
        box2.setIcon(null);
        redThreshold.setEnabled(true);
        redValue.setEnabled(true);
        greenThreshold.setEnabled(true);
        greenValue.setEnabled(true);
        blueThreshold.setEnabled(true);
        blueValue.setEnabled(true);

    }//GEN-LAST:event_resetButtonActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        /****************************************************************************/
        //A thread is created to write a html file that has data about the movement
        //A thread was used because when separate threads are created to take care 
        //of a process, the program doesn't sit and wait for the task to be completed.
        /****************************************************************************/
//        Runnable write_results = new Runnable() {
//
//            String [][] values = new String[fa.VID_LENGTH][2]; 
//            public void run() {
//                try {
//                    for (int sec = 0; sec < values.length; sec++)
//                    {
//                        values[sec] = fa.
//                    }
//                    HTMLUtilities.generateGoogleLineChart(dir.getName(), dir.getName(), "Second", "Movement", values);
//                    dt.open(new File(dir.getName() + ".html"));
//    //                FileWriter fw = null;
//    //                try {
//    //                    String file = dir.getName() + "_results.html";
//    //                    fw = new FileWriter(file);
//    //
//    //                    results = "<html><title></title><body>" + "\\*****Tracking results of " + dir.getName() + "*****/</br></br></br>"
//    //                            + "Number of Frames - " + fa.frames.size() + "<br /><br />" + ""
//    //                            + "Video length - " + fa.VID_LENGTH + " seconds<br /><br />" + ""
//    //                            + "Location at:<br />";
//    //                    for (int sec = 0; sec < fa.VID_LENGTH; sec++) {
//    //                        results += "  " + (sec + 1) + ":  " + "X:" + fa.locationAtTime(sec).x + " , "
//    //                                + "Y: " + fa.locationAtTime(sec).y + "<br />";
//    //                    }
//    //                    results += "</body></html>";
//    //
//    //                    fw.write(results);
//    //                    fw.close();
//    //                    dt.open(new File(file));
//    //                    results = "";
//    //                } catch (IOException ex) {
//    //                    Logger.getLogger(FishAnalyzerApp.class.getName()).log(Level.SEVERE, null, ex);
//    //                } finally {
//    //                    try {
//    //                        fw.close();
//    //                    } catch (IOException ex) {
//    //                        Logger.getLogger(FishAnalyzerApp.class.getName()).log(Level.SEVERE, null, ex);
//    //                    }
//    //                }
//                } catch (IOException ex) {
//                    Logger.getLogger(FishAnalyzerApp.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//
//        Thread writeFile = new Thread(write_results);
//        writeFile.start();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FishAnalyzerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FishAnalyzerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FishAnalyzerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FishAnalyzerApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FishAnalyzerApp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider blueThreshold;
    private javax.swing.JSlider blueValue;
    private javax.swing.JLabel box1;
    private javax.swing.JLabel box2;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel framesLabel;
    private javax.swing.JSlider greenThreshold;
    private javax.swing.JSlider greenValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel loadLabel;
    private javax.swing.JSlider redThreshold;
    private javax.swing.JSlider redValue;
    private javax.swing.JButton resetButton;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JButton trackButton;
    private javax.swing.JLabel xLoc;
    private javax.swing.JLabel yLoc;
    // End of variables declaration//GEN-END:variables
}
