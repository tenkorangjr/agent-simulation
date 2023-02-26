import java.util.Random;

public class AgentSimulation {
    public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        LandscapeDisplay display = new LandscapeDisplay(scape);
        Random gen = new Random();

        for (int i = 0; i < 100; i++) {
            scape.addAgent(new SocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    25));
            scape.addAgent(new AntiSocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    50));
        }

        while (true) {
            Thread.sleep(100);
            scape.updateAgents();
            display.repaint();
        }
    }
}
