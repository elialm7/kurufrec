package View;

import Interactor.MainViewInteractor;
import UIStateModel.MainViewStateModel;
import Controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView {


    private MainViewController controller;
    private MainViewStateModel stateModel;
    private MainViewInteractor interactor;
    private Stage mainStage;

    public MainView(Stage st){
        this.mainStage = st;
        this.stateModel = new MainViewStateModel();
    }
    public void show(){
        try {
            interactor = new MainViewInteractor(stateModel);
            controller = new MainViewController(stateModel, interactor, mainStage);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlViews/kurufrecmainviev.fxml"));
            loader.setController(controller);
            mainStage.setScene(new Scene(loader.load()));
            mainStage.setTitle("KuruFrec");
            mainStage.setResizable(false);
            mainStage.show();
        }catch (IOException e){
            // todo: add logging.
            e.printStackTrace();
        }
    }
}
