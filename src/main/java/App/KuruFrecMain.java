package App;

import Controller.MainController;

import java.nio.file.Path;
import java.nio.file.Paths;

public class KuruFrecMain {
    public static void main(String[] args) {
        MainController controller = new MainController(args);
        controller.start();
    }

}
