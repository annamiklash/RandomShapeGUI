package controller;

import controller.listener.ListenersInit;
import generator.RandomGenerator;
import model.Ellipse;
import model.Rectangle;
import model.Shape;
import model.Triangle;
import util.FileUtil;
import view.Window;

import java.util.List;

public class Controller {

    private Window window;


    public Controller(Window window) {
        this.window = window;


        ListenersInit.addGenerateButtonListener(window.getGenerateRandomShapesButton(), this);
        ListenersInit.addSaveButtonListener(window.getSaveToFileButton(), this);
        ListenersInit.addLoadButtonListener(window.getLoadFromFileButton(), this);
    }

    public void generate() {
        PaintingThread paintingThread = new PaintingThread(this);
        paintingThread.start();
    }

    public void save() {
        FileUtil.saveToFile(window.getShapeList());
    }

    public void load() {
        List<Shape> shapeList = FileUtil.readFromFile();
        window.repaintLoadedShapeList(shapeList);
    }

    void generateRandomShape() {
        int shapeChoice = RandomGenerator.generateInt();

        if (shapeChoice == 0) {
            window.addShapeToLeftPanel(new Rectangle());
        } else if (shapeChoice == 1) {
            window.addShapeToLeftPanel(new Triangle());
        } else if (shapeChoice == 2) {
            window.addShapeToLeftPanel(new Ellipse());
        }
    }

}
