/*
 * Author: Michael Tenkorang
 * Title: Agent-Based Simulation
 * Date: 02/26/2023
 * CS 231
 * Section B
 * Landscape.java
 */

import java.lang.Math;
import java.awt.Graphics;

public class Landscape {
    int width;
    int height;

    LinkedList<Agent> agents;

    public Landscape(int w, int h) {
        /*
         * Constructor for landscape
         */
        width = w;
        height = h;

        agents = new LinkedList<>();
    }

    public void updateAgents() {
        /*
         * Update the agents on the screen
         */
        for (Agent a : agents) {
            a.updateState(this);
        }
    }

    public void draw(Graphics g) {
        /*
         * Draw the agents on the window
         */
        for (Agent a : agents) {
            a.draw(g);
        }
    }

    public int getHeight() {
        /*
         * Returns the height of the Landscape
         */

        return height;
    }

    public int getWidth() {
        /*
         * Returns the width of the landscape
         */
        return width;
    }

    public void addAgent(Agent a) {
        /*
         * Inserts an agent at the begining of its list of agents
         */
        agents.add(a);
    }

    public String toString() {
        /*
         * Returns a string representation of the list of agents
         */
        return "" + agents.size();
    }

    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius) {
        /*
         * Gets the Neighbors of an agent
         */
        LinkedList<Agent> res = new LinkedList<>();
        for (Agent a : agents) {
            if ((a.x == x0) && (a.y == y0)) {
                continue;
            }
            if (radius >= (Math.sqrt(Math.pow(a.x - x0, 2) + Math.pow(a.y - y0, 2)))) {
                res.add(a);
            }
        }
        return res;
    }
}