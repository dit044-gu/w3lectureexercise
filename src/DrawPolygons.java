import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;
import shapes.Polygon;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class DrawPolygons extends JComponent {
    public List<Polygon> polygons; // DIP dependency inversion principle
    /*
       Instead of depending on a concrete class (ArrayList),
       we're depending on an interface that ArrayList implements
       (called List)
       interfaces are more abstract than the classes that implement them
     */
    public boolean direction = true;
    public int ticker = 0;
    private Frame frame;

    public DrawPolygons() {
        polygons = new ArrayList<>(10);

        polygons.add(new Square(50,50));
        polygons.add(new Triangle(100,100));
        polygons.add(new Rectangle(50,150));
    }

    public void update() {
        ticker++;
        int value = direction ? 10 : -10;
        for (Polygon p: polygons) {
            p.updateCenter(p.centerPoint.x+value, p.centerPoint.y+value);
        }
        frame.repaint();

        if (ticker > 10) {
            direction = !direction;
            ticker = 0;
        }
    }

    @Override
    public void paint(Graphics g) {
        for (Polygon currentPolygon : polygons) {
            currentPolygon.paint(g);
        }
    }

    static void main() {
        JFrame frame = new JFrame();
        DrawPolygons polygons = new DrawPolygons();
        polygons.frame = frame;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);


        // We haven't talked about try/catch statements yet.
        // Don't worry about them for now.
        try {
            while (true) {
                Thread.sleep(500);
                polygons.update();
            }
        } catch (InterruptedException e) {}
    }
}