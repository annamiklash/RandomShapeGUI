package model;

import java.awt.*;

public class Rectangle extends Shape {
    public Rectangle(float resultX, float resultY, float resultWidth, float resultHeight, Color color) {
        super(resultX, resultY, resultWidth, resultHeight, color);
    }

    public Rectangle() {
        super();
    }

    @Override
    public void paint(Graphics g, Dimension panelSize) {
        g.setColor(getColor());
        g.fillRect(getX(panelSize.getWidth()),
                getY(panelSize.getHeight()),
                getWidth(panelSize.getWidth()),
                getHeight(panelSize.getHeight()));


    }

    @Override
    public String toString() {
        return "Rectangle:" +
                "x=" + x +
                ",y=" + y +
                ",width=" + width +
                ",height=" + height +
                ",color=" + color;
    }
}
