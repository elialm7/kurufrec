package View;

import Interactor.MainViewInteractor;
import controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Builder;

import java.io.IOException;

public class MainView {


    private MainViewController controller;
    private Stage st;

    public MainView(Stage st){
        this.st = st;
    }

    public Scene getView() throws IOException {
        controller = new MainViewController();
        controller.setMainViewStage(st);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlViews/kurufrecmainviev.fxml"));
        loader.setController(controller);
        return new Scene(loader.load());
    }

    public MainViewController getController(){
        return this.controller;
    }
}
