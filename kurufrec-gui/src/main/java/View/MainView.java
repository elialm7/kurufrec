package View;

import Interactor.MainViewInteractor;
import View.ViewState.MainView.ActionsMainViewState;
import View.ViewState.MainView.OptionsMainViewState;
import View.ViewState.MainView.ReportMainViewState;
import Controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView {


    private MainViewController controller;
    private OptionsMainViewState optionsState;
    private ActionsMainViewState actionsState;
    private ReportMainViewState reportState;
    private MainViewInteractor interactor;
    private Stage mainStage;

    public MainView(Stage st){
        this.mainStage = st;
        this.actionsState = new ActionsMainViewState();
        this.reportState = new ReportMainViewState();
        this.optionsState = new OptionsMainViewState();
    }
    public void show(){
        try {
            interactor = new MainViewInteractor();
            controller = new MainViewController(interactor, mainStage);
            controller.bindActionsState(actionsState);
            controller.bindOptionsState(optionsState);
            controller.bindReportState(reportState);
            interactor.bindActionsState(actionsState);
            interactor.bindOptionsState(optionsState);
            interactor.bindReportState(reportState);
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
