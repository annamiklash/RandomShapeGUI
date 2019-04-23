import controller.Controller;
import util.FileUtil;
import controller.PrintingThread;
import model.Shape;
import view.Window;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Window window = new Window();

        Controller controller = new Controller(window);

    }
}
