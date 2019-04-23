package controller;

import static common.Constants.INTERVAL;
import static common.Constants.NUMBER_OF_SHAPES;

public class PaintingThread extends Thread {

    private Controller controller;

    public PaintingThread(Controller controller){
        this.controller = controller;

    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_SHAPES; i++) {
            controller.generateRandomShape();
            try {
                sleep(INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
