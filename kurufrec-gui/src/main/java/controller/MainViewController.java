package controller;

import Interactor.MainViewInteractor;

import UIStateModel.MainViewStateModel;
import UIStateModel.MainViewStateModelListener;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainViewController implements Initializable, MainViewStateModelListener {
    @FXML
    private TextArea LogArea;
    @FXML
    private Button frecuencyStartButton;
    @FXML
    private Button openFileButton;
    @FXML
    private CheckBox openfinishing;
    @FXML
    private CheckBox filter;
    @FXML
    private Label statelabel;
    private Stage mainViewStage;
    private MainViewInteractor interactor;
    private MainViewStateModel statemodel;
    public MainViewController(MainViewStateModel stateModel, MainViewInteractor interactor,Stage mainviewstage) {
        this.mainViewStage = mainviewstage;
        this.statemodel = stateModel;
        this.interactor = interactor;
        this.statemodel.addlistener(this);
    }
    private void openfile(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose a file.");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        chooser.getExtensionFilters().add(extFilter);
        File chosenfile = chooser.showOpenDialog(mainViewStage);
        if(Objects.isNull(chosenfile)){
            return;
        }
        statemodel.setLogAreatext("");
        statemodel.setSelectedfile(chosenfile);
        statemodel.appendlogAreaText("File selected: "+chosenfile.getName());
    }
    private void startFrecuency(){
        Task<Void> frecuencyBackgroundThread = new Task<>() {
            @Override
            protected Void call() throws Exception {
                interactor.executeFrecuency();
                return null;
            }
        };
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(frecuencyBackgroundThread);
        service.shutdown();
    }
    private void updateFilterUIstate(boolean t1){
        this.statemodel.setOnFiltering(t1);
    }
    private void updateOpenafterFinishingUIstate(boolean t1){
        this.statemodel.setOnOpeningAfter(t1);
    }
    private void bindComponents(){
        this.openFileButton.setOnAction(actionEvent -> openfile());
        this.frecuencyStartButton.setOnAction(actionEvent -> startFrecuency());
        this.filter.selectedProperty().addListener((observableValue, aBoolean, t1) -> updateFilterUIstate(t1));
        this.openfinishing.selectedProperty().addListener((observablevalue, aboolean, t1)->{updateOpenafterFinishingUIstate(t1);});
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bindComponents();
    }
    @Override
    public void onMainViewStateChanged(MainViewStateModel newState) {
        updateUIState(newState);
    }
    private void updateUIState(MainViewStateModel newState){
        this.LogArea.setText(newState.getLogAreatext());
        this.statelabel.setText(newState.getProgresslabel());
    }
}
