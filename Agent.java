import java.awt.Graphics;

public abstract class Agent {
    double x;
    double y;

    public Agent(double x0, double y0) {
        x = x0;
        y = y0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double newX) {
        x = newX;
    }

    public void setY(double newY) {
        y = newY;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public abstract void updateState(Landscape scape);

    public abstract void draw(Graphics g);
}
