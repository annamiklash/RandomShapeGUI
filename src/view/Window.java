package view;

import generator.RandomGenerator;
import model.Oval;
import model.Rectangle;
import model.Shape;
import model.Triangle;

import javax.swing.*;

import java.awt.*;
import java.util.List;


import static common.Constants.WINDOW_HEIGHT;
import static common.Constants.WINDOW_WIDTH;

public class Window extends JFrame {

    private PaintingPanel leftPaintingPanel;
    private PaintingPanel rightLoadingPanel;

    private JButton generateRandomShapesButton;
    private JButton saveToFileButton;
    private JButton loadFromFileButton;

    private JLabel generatedRandomShapesLabel;
    private JLabel loadedFromFileLabel;


    public Window() {

        initializeWindow();
        initializePanels();
        initializeLayout();

    }



    public void addShapeToLeftPanel(Shape shape) {
        List<Shape> shapesList = leftPaintingPanel.getShapesList();
        shapesList.add(shape);
        leftPaintingPanel.repaint();

    }

    public void repaintLoadedShapeList(List<Shape> shapeList) {
        rightLoadingPanel.setShapesList(shapeList);
        rightLoadingPanel.repaint();
    }

    public List<Shape> getShapeList() {
        return leftPaintingPanel.getShapesList();
    }


    public PaintingPanel getLeftPaintingPanel() {
        return leftPaintingPanel;
    }

    public PaintingPanel getRightLoadingPanel() {
        return rightLoadingPanel;
    }

    public JButton getGenerateRandomShapesButton() {
        return generateRandomShapesButton;
    }

    public JButton getSaveToFileButton() {
        return saveToFileButton;
    }

    public JButton getLoadFromFileButton() {
        return loadFromFileButton;
    }

    public JLabel getGeneratedRandomShapesLabel() {
        return generatedRandomShapesLabel;
    }

    public JLabel getLoadedFromFileLabel() {
        return loadedFromFileLabel;
    }

    private void initializeWindow() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Window");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null); //window appears in the middle of the screen
    }

    private void initializePanels() {

        generateRandomShapesButton = new JButton("Generate Shapes");
        saveToFileButton = new JButton("Save To File");
        loadFromFileButton = new JButton("Load From File");

        generatedRandomShapesLabel = new JLabel("Printed Random Shapes");
        loadedFromFileLabel = new JLabel("Shapes Loaded From File");

        leftPaintingPanel = new PaintingPanel();
        rightLoadingPanel = new PaintingPanel();

    }

    private void initializeLayout() {
        GroupLayout layout = new GroupLayout(getContentPane()); //group layout to work with horizontal and vertical separately
        this.setLayout(layout); //associate groupLayout object with window
        layout.setAutoCreateGaps(true); //automatic gap insertion
        layout.setAutoCreateContainerGaps(true);

        //define the groups and add the components:
        // 1. horizontal root group
        layout.setHorizontalGroup(
                layout.createSequentialGroup() //method to create groups
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER) // create parallel group in a horizontal gr
                                //and align in center in both dimensions for left panel and and left label
                                .addComponent(generatedRandomShapesLabel)
                                .addComponent(leftPaintingPanel)
                                .addGroup(layout.createSequentialGroup() //a separate group for 2 buttons at the bottom
                                        .addComponent(generateRandomShapesButton)
                                        .addComponent(saveToFileButton)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER) // parallel centered group for right panel
                                //and right jlabel
                                .addComponent(rightLoadingPanel)
                                .addComponent(loadedFromFileLabel)
                                .addComponent(loadFromFileButton))

        );

        // 2. vertical root group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //leading: left to right. group for labels
                                .addComponent(generatedRandomShapesLabel)
                                .addComponent(loadedFromFileLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //group for panels
                                .addComponent(leftPaintingPanel)
                                .addComponent(rightLoadingPanel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)//group for buttons
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) // separate group for 2 buttons after right panel
                                        .addComponent(generateRandomShapesButton)
                                        .addComponent(saveToFileButton))
                                .addComponent(loadFromFileButton)) // load button stands alone after right panel
        );
    }
}
