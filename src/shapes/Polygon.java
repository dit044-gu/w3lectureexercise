package shapes;

import javax.swing.*;
import java.awt.*;

public abstract class Polygon extends JComponent {
    public Point centerPoint; //protected makes it accessible in subclasses

    // better way: make it private and have getters for the subclasses to use


    public Polygon(Point center) {
        this.centerPoint = center;
    }

    public Polygon(int x, int y) {
        this(new Point(x,y));
    }

    public void updateCenter(int x, int y) {
        this.centerPoint = new Point(x,y);
        //drawer.frame.repaint();
    }

    @Override
    public abstract void paint(Graphics g);
}
