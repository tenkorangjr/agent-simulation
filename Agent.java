/*
 * Author: Michael Tenkorang
 * Title: Agent-Based Simulation
 * Date: 02/26/2023
 * CS 231
 * Section B
 * Agent.java
 */

import java.awt.Graphics;

public abstract class Agent {
    double x;
    double y;

    public Agent(double x0, double y0) {
        /*
         * Constructor for agent
         */
        x = x0;
        y = y0;
    }

    public double getX() {
        /*
         * Get the x value of the position of an agent
         */
        return x;
    }

    public double getY() {
        /*
         * Get the y value of the position of an agent
         */
        return y;
    }

    public void setX(double newX) {
        /*
         * Sets the x value of the position of the agent
         */
        x = newX;
    }

    public void setY(double newY) {
        /*
         * Sets the y value of the position of the agent
         */
        y = newY;
    }

    public String toString() {
        /*
         * String representation of the position of an agent
         */
        return "(" + x + ", " + y + ")";
    }

    public abstract void updateState(Landscape scape);

    public abstract void draw(Graphics g);
}
