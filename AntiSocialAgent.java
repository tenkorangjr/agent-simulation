public class AntiSocialAgent extends Agent {

    int radius;
    boolean moved;

    public AntiSocialAgent(double x0, double y0, int radius) {
        super(x0, y0);
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public void draw(Graphics g) {
        if (!moved)
            g.setColor(new Color(0, 0, 255));
        else
            g.setColor(new Color(125, 125, 255));

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape) {
        assert (true);
    }
}
