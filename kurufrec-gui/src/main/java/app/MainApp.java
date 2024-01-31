package app;
import Interactor.MainViewInteractor;
import View.MainView;
import controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApp extends Application{
    public static void main(String[] args){
    launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        MainView mainView = new MainView(stage);
        mainView.show();
    }

}
