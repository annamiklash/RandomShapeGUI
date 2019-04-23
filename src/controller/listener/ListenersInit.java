package controller.listener;


import controller.Controller;

import javax.swing.*;

public class ListenersInit {

    public static void addGenerateButtonListener(JButton button, Controller controller) {
        button.addActionListener(new GenerateButtonListener(controller));
    }

    public static void addSaveButtonListener(JButton button, Controller controller) {
        button.addActionListener(new SaveButtonListener(controller));
    }

    public static void addLoadButtonListener(JButton button, Controller controller) {
        button.addActionListener(new LoadButtonListener(controller));
    }

}
