/*
 * Author: Michael Tenkorang
 * Title: Agent-Based Simulation
 * Date: 02/26/2023
 * CS 231
 * Section B
 * AgentTest.java
 */

public class AgentTest {
    public static void main(String[] args) {
        {
            /*
             * Test Constructor for agents
             */
            // Setup
            SocialAgent socialAgent = new SocialAgent(50, 50, 50);
            AntiSocialAgent antiSocialAgent = new AntiSocialAgent(50, 70, 10);

            // verify
            System.out.println(socialAgent.getRadius() + " == 50");
            System.out.println(socialAgent.getX() + " == 50.0");
            System.out.println(socialAgent.getY() + " == 50.0");

            System.out.println(antiSocialAgent.getRadius() + " == 10");
            System.out.println(antiSocialAgent.getX() + " == 50.0");
            System.out.println(antiSocialAgent.getY() + " == 70.0");

            // test setRadius
            socialAgent.setRadius(20);

            // verify
            System.out.println(socialAgent.getRadius() + " == 20");

        }
        {
            // Setup
            SocialAgent socialAgent = new SocialAgent(10, 50, 200);
            SocialAgent socialAgent1 = new SocialAgent(20, 60, 50);
            Landscape scape = new Landscape(500, 500);
            scape.addAgent(socialAgent1);
            scape.addAgent(socialAgent);
            socialAgent.updateState(scape);

            // Verify
            System.out.println(socialAgent.getX() + " " + socialAgent.getY() + " != 10 50 (after 5 runs at least)");

        }
    }
}
