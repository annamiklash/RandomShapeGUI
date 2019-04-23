import controller.Controller;
import view.Window;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Window window = new Window();

        Controller controller = new Controller(window);

    }
}
