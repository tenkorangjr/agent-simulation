/*
 * Author: Michael Tenkorang
 * Title: Agent-Based Simulation
 * Date: 02/26/2023
 * CS 231
 * Section B
 * SocialAgent.java
 */

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class SocialAgent extends Agent {

    int radius;
    boolean moved;
    Random randomPicker;

    public SocialAgent(double x0, double y0, int radius) {
        /*
         * Constructor for the agent
         */
        super(x0, y0);
        this.radius = radius;
        moved = false;
        randomPicker = new Random();
    }

    public void setRadius(int radius) {
        /*
         * Set the radius of the agent
         */
        this.radius = radius;
    }

    public int getRadius() {
        /*
         * get the radius of an agent
         */
        return this.radius;
    }

    public void draw(Graphics g) {
        /*
         * Draw an agent on landscape
         */
        if (!extension) {
            if (!moved) {
                g.setColor(new Color(0, 0, 255));
            } else {
                g.setColor(new Color(125, 125, 255));
            }
        } else {
            // Use random colors when extension field is true
            g.setColor(new Color(randomPicker.nextInt(0, 255), randomPicker.nextInt(0, 255),
                    randomPicker.nextInt(0, 255)));
        }

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape) {
        /*
         * Update the state of agent on window
         */
        if (scape.getNeighbors(x, y, radius).size() < 4) {
            this.moved = true;
            if ((x - 10) < 0) {
                this.x += randomPicker.nextInt(0, 10);
            } else if ((x + 10) >= scape.width) {
                this.x += randomPicker.nextInt(-10, 0);
            } else {
                this.x += randomPicker.nextInt(-10, 10);
            }
            if ((y - 10) < 0) {
                this.y += randomPicker.nextInt(0, 10);
            } else if ((y + 10) >= scape.height) {
                this.y += randomPicker.nextInt(-10, 0);
            } else {
                this.y += randomPicker.nextInt(-10, 10);
            }
        } else {
            this.moved = false;
        }
    }
}
