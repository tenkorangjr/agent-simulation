/*
 * Author: Michael Tenkorang
 * Title: Agent-Based Simulation
 * Date: 02/26/2023
 * CS 231
 * Section B
 * LandscapeTest.java
 */

public class LandscapeTest {
    public static void main(String[] args) {
        {
            // Test getWidth(), getHeight() and toString()
            // setup
            Landscape scape = new Landscape(200, 500);

            // verify
            System.out.println(scape + " == 0");
            System.out.println(scape.getHeight() + " == 500");
            System.out.println(scape.getWidth() + " == 200");

            // test
            assert scape != null : "Error in Landscape::Landscape()";
            assert scape.toString() == "0" : "Error in Landscape::size() or Landscape::toString()";
        }
        {
            // Test addAgent()
            // setup
            Landscape scape = new Landscape(100, 100);
            scape.addAgent(new SocialAgent(10, 50, 5));
            scape.addAgent(new AntiSocialAgent(100, 200, 10));

            // verify
            System.out.println(scape + " == 2");

            // test
            assert scape.toString() == "2" : "Error in Landscape::Landscape()";
        }
        {
            // Test getNeighbors
            // setup
            Landscape scape = new Landscape(200, 500);

            // verify
            System.out.println(scape + " == 0");
            System.out.println(scape.getHeight() + " == 500");
            System.out.println(scape.getWidth() + " == 200");

            // test
            assert scape != null : "Error in Landscape::Landscape()";
        }
    }
}
