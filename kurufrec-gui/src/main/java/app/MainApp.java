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

    private static Logger log = LogManager.getLogger(MainApp.class);
    public static void main(String[] args){
    launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        log.info("Starting controller and loading fxmls...");
        MainView mainView = new MainView(stage);
        MainViewInteractor interactor = new MainViewInteractor();
        stage.setScene(mainView.getView());
        interactor.setController(mainView.getController());
        interactor.show();
    }
}
