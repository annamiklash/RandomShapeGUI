package util;

import model.Oval;
import model.Rectangle;
import model.Shape;
import model.Triangle;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static common.Constants.FILE_NAME;


public class FileUtil {
    final static String RECTANGLE = "Rectangle:x=";
    final static String TRIANGLE = "Triangle:x=";
    final static String OVAL = "Oval:x=";


    public static void saveToFile(List<Shape> shapeList) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            synchronized (shapeList) {
                for (Shape shape : shapeList) {
                    writer.write(shape.toString() + '\n');
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Shape> readFromFile() {
        List<Shape> resultShapeList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
            String line = bufferedReader.readLine();

            while (line != null) {
                resultShapeList.add(deserialize(line));
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultShapeList;
    }

    private static Shape deserialize(String line) { //create shapes from string
        if (line.contains(RECTANGLE)) {
            return buildShapeFromFile(RECTANGLE, line);

            //paint rectangle in the right panel
            //return Rectangle
        } else if (line.contains(TRIANGLE)) {
            return buildShapeFromFile(TRIANGLE, line);

            //paint Triangle in the right panel
            //return Triangle
        } else if (line.contains(OVAL)) {
            return buildShapeFromFile(OVAL, line);
            //paint Oval in the right panel
            //return Oval

        }
        return null;

    }

    private static Shape buildShapeFromFile(String start, String line) {
        int beginIndex = start.length();
        int endIndex = line.indexOf(",y=");
        float resultX = Float.parseFloat(line.substring(beginIndex, endIndex));

        beginIndex = endIndex + 3;
        endIndex = line.indexOf(",width=");
        float resultY = Float.parseFloat(line.substring(beginIndex, endIndex));

        beginIndex = endIndex + 7;
        endIndex = line.indexOf(",height=");
        float resultWidth = Float.parseFloat(line.substring(beginIndex, endIndex));

        beginIndex = endIndex + 8;
        endIndex = line.indexOf(",color=java.awt.Color[r=");
        float resultHeight = Float.parseFloat(line.substring(beginIndex, endIndex));

        beginIndex = endIndex + 24;
        endIndex = line.indexOf(",g=");
        float resultColorR = Float.parseFloat(line.substring(beginIndex, endIndex));
        int colorR = (int) resultColorR;

        beginIndex = endIndex + 3;
        endIndex = line.indexOf(",b=");
        float resultColorG = Float.parseFloat(line.substring(beginIndex, endIndex));
        int colorG = (int) resultColorG;

        beginIndex = endIndex + 3;
        endIndex = line.indexOf("]");
        float resultColorB = Float.parseFloat(line.substring(beginIndex, endIndex));
        int colorB = (int) resultColorB;
        Color color = new Color(colorR, colorG, colorB);


        if (line.contains(RECTANGLE)) {
            return new Rectangle(resultX, resultY, resultWidth, resultHeight, color);
        } else if (line.contains(TRIANGLE)) {
            return new Triangle(resultX, resultY, resultWidth, resultHeight, color);
        } else {
            return new Oval(resultX, resultY, resultWidth, resultHeight, color);
        }

    }

}
