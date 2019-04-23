package model;

import java.awt.*;

public class Triangle extends Shape {


    public Triangle(float resultX, float resultY, float resultWidth, float resultHeight, Color color) {
        super(resultX, resultY, resultWidth, resultHeight, color);
    }

    public Triangle() {
        super();
    }

    @Override
    public void paint(Graphics g, Dimension panelSize) {
        g.setColor(getColor());

        Point point = new Point(getX(panelSize.getWidth()), getY(panelSize.getHeight()));
        int[] cordX = {getX(panelSize.getWidth()),
                (int) (point.x + width * (panelSize.getWidth() / 4)),
                (int) (point.x + width * (panelSize.getWidth() / 4) / 2)};
        int[] cordY = {point.y, point.y, (int) (point.y - height * (panelSize.getHeight() / 4))};

        g.fillPolygon(cordX, cordY, 3);

    }

    @Override
    public String toString() {
        return "Triangle:" +
                "x=" + x +
                ",y=" + y +
                ",width=" + width +
                ",height=" + height +
                ",color=" + color;
    }
}
