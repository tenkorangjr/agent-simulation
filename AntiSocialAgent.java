import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class AntiSocialAgent extends Agent {

    int radius;
    boolean moved;
    Random randomPicker;

    public AntiSocialAgent(double x0, double y0, int radius) {
        super(x0, y0);
        this.radius = radius;
        moved = false;
        randomPicker = new Random();
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public void draw(Graphics g) {
        if (!moved)
            g.setColor(new Color(255, 0, 0));
        else
            g.setColor(new Color(255, 125, 125));

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape) {
        if (scape.getNeighbors(x, y, radius).size() > 1) {
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
