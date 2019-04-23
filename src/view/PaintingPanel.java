package view;

import model.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static common.Constants.WINDOW_HEIGHT;
import static common.Constants.WINDOW_WIDTH;

public class PaintingPanel extends JPanel {
    private List<Shape> shapesList;

    public PaintingPanel() {
        this.shapesList = new ArrayList<>();

        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(WINDOW_WIDTH / 2, HEIGHT));
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Shape shape : shapesList) {
            shape.paint(g, this.getSize());
        }

    }

    public List<Shape> getShapesList() {
        return shapesList;
    }

    public void setShapesList(List<Shape> shapesList) {
        this.shapesList = shapesList;
    }

    @Override
    public String toString() {
        return "PaintingPanel{" +
                "shapesList=" + shapesList +
                '}';
    }
}
