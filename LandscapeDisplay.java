/*
 * Author: Michael Tenkorang
 * Title: Agent-Based Simulation
 * Date: 02/26/2023
 * CS 231
 * Section B
 * LandscapeDisplay.java
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Displays a Landscape graphically using Swing. In this version, we do not
 * assume
 * the Landscape is a grid.
 */
public class LandscapeDisplay {
    protected JFrame win;
    protected Landscape scape;
    public LandscapePanel canvas;

    /**
     * Initializes a display window for a Landscape.
     * 
     * @param scape the Landscape to display
     */
    public LandscapeDisplay(Landscape scape) {
        // setup the window
        this.win = new JFrame("Agents");
        this.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.scape = scape;

        // create a panel in which to display the Landscape
        this.canvas = new LandscapePanel(this.scape.getWidth(),
                this.scape.getHeight());

        // add the panel to the window, layout, and display
        this.win.add(this.canvas, BorderLayout.CENTER);
        this.win.pack();
        this.win.setVisible(true);
    }

    /**
     * Saves an image of the display contents to a file. The supplied
     * filename should have an extension supported by javax.imageio, e.g.
     * "png" or "jpg".
     *
     * @param filename the name of the file to save
     */
    public void saveImage(String filename) {
        // get the file extension from the filename
        String ext = filename.substring(filename.lastIndexOf('.') + 1, filename.length());

        // create an image buffer to save this component
        Component tosave = this.win.getRootPane();
        BufferedImage image = new BufferedImage(tosave.getWidth(), tosave.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        // paint the component to the image buffer
        Graphics g = image.createGraphics();
        tosave.paint(g);
        g.dispose();

        // save the image
        try {
            ImageIO.write(image, ext, new File(filename));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * This inner class provides the panel on which Landscape elements
     * are drawn.
     */
    public class LandscapePanel extends JPanel implements ActionListener {
        /**
         * Creates the panel.
         * 
         * @param width  the width of the panel in pixels
         * @param height the height of the panel in pixels
         */

        public JButton btn; // for Pause button
        public JButton btn1; // for change color button
        boolean pause = false; // check if pause button has been clicked
        boolean color = false; // check if random colors button has been clicked

        public LandscapePanel(int width, int height) {
            super();
            this.btn = new JButton("Pause");
            this.btn1 = new JButton("Random Colors");
            this.setPreferredSize(new Dimension(width, height));
            this.setBackground(Color.white);
            this.add(btn);
            this.add(btn1);

            btn.addActionListener(this);
            btn1.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source.equals(this.btn)) { // negate the value of pause when the pause button is pressed
                System.out.println("true");
                pause = !(pause);
            } else if (source.equals(this.btn1)) { // negate the value of random when the random button is pressed
                color = !(color);
            }
        }

        /**
         * Method overridden from JComponent that is responsible for
         * drawing components on the screen. The supplied Graphics
         * object is used to draw.
         * 
         * @param g the Graphics object used for drawing
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            scape.draw(g);
        } // end paintComponent

    } // end LandscapePanel

    public void repaint() {
        this.win.repaint();
    }

    // test function that creates a new LandscapeDisplay and populates it with 200
    // agents.
    public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(500, 500);
        Random gen = new Random();

        // Creates 100 SocialAgents and 100 AntiSocialAgents
        for (int i = 0; i < 100; i++) {
            scape.addAgent(new SocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    25));
            scape.addAgent(new AntiSocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    50));
        }

        LandscapeDisplay display = new LandscapeDisplay(scape);

        // Uncomment below when updateAgents() has been implemented
        while (true) {
            Thread.sleep(10);
            scape.updateAgents();
            display.repaint();
        }
    }
}