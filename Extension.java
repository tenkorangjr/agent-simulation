/*
 * Author: Michael Tenkorang
 * Title: Agent-Based Simulation
 * Date: 02/26/2023
 * CS 231
 * Section B
 * Extension.java
 */

import java.util.Random;

public class Extension {
    public static void main(String[] args) throws InterruptedException {
        /*
         * Shows screen and agents
         */

        Landscape scape = new Landscape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        LandscapeDisplay display = new LandscapeDisplay(scape);
        Random gen = new Random();

        // int tester = 0;

        for (int i = 0; i < 100; i++) {
            scape.addAgent(new SocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    30));
            scape.addAgent(new AntiSocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    30));
        }

        while (true) {
            if (display.canvas.pause) {
                break;
            }
            if (display.canvas.color) {
                for (Agent a : scape.agents) {
                    a.extension = !(a.extension);
                }
                display.canvas.color = false;
            }
            Thread.sleep(100);
            scape.updateAgents();
            display.repaint();
        }
    }
}
