package model;

import java.awt.*;

public class Oval extends Shape {


    public Oval(float resultX, float resultY, float resultWidth, float resultHeight, Color color) {
        super(resultX, resultY, resultWidth, resultHeight, color);

    }

    public Oval() {
        super();
    }

    @Override
    public void paint(Graphics g, Dimension panelSize) {
        g.setColor(getColor());
        g.fillOval(getX(panelSize.getWidth()),
                getY(panelSize.getHeight()),
                getWidth(panelSize.getWidth()),
                getHeight(panelSize.getHeight()));
    }

    @Override
    public String toString() {
        return "Oval:" +
                "x=" + x +
                ",y=" + y +
                ",width=" + width +
                ",height=" + height +
                ",color=" + color;
    }
}
