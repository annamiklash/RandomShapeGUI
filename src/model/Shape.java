package model;

import java.awt.*;

import static generator.RandomGenerator.generateColor;
import static generator.RandomGenerator.generateFloat;

public abstract class Shape {

    final float x;
    final float y;
    final float width;
    final float height;
    final Color color;

    public Shape() {
        this.x = generateFloat();
        this.y = generateFloat();
        this.width = generateFloat();
        this.height = generateFloat();
        this.color = generateColor();
    }

    public Shape(float resultX, float resultY, float resultWidth, float resultHeight, Color color) {
        this.x = resultX;
        this.y = resultY;
        this.width = resultWidth;
        this.height = resultHeight;
        this.color = color;
    }

    public int getX(double panelWidth) {
        return (int) (this.x * panelWidth);
    }

    public int getY(double panelHeight) {
        return (int) (this.y * panelHeight);
    }

    public int getWidth(double panelWidth) {
        return (int) (this.width * panelWidth * 0.25);
    }

    public int getHeight(double panelHeight) {
        return (int) (this.height * panelHeight * 0.25);
    }

    public Color getColor() {
        return this.color;
    }

    public abstract void paint(Graphics g, Dimension panelSize);

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ",y=" + y +
                ",width=" + width +
                ",height=" + height +
                ",color=" + color +
                '}';
    }
}
