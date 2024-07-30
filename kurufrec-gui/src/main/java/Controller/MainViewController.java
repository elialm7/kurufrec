package Controller;

import Interactor.MainViewInteractor;
import Interactor.MainViewInteractor;

import View.ViewState.MainView.ActionsMainViewState;
import View.ViewState.MainView.OptionsMainViewState;
import View.ViewState.MainView.ReportMainViewState;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MainViewController {
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
    @FXML
    private ProgressBar progressbar;
   /** private Stage mainViewStage;
    private MainViewInteractor interactor;

    private OptionsMainViewState OptionState;
    private ReportMainViewState ReportState;
    private ActionsMainViewState ActionState;
    public MainViewController(MainViewInteractor interactor,Stage mainviewstage) {
        this.mainViewStage = mainviewstage;
        this.interactor = interactor;

    }
    public void bindActionsState(ActionsMainViewState actionsState){
        this.ActionState = actionsState;
    }
    public void bindReportState(ReportMainViewState reportState){
        this.ReportState = reportState;
    }
    public void bindOptionsState(OptionsMainViewState optionState){
        this.OptionState = optionState;
    }
    private void addListenertoStates(){
        //for now there's no need to update the options checkboxes.
        this.ActionState.addStateListener(toHandle -> {
            updateFrecuencyActionButton(toHandle.isFrecuencyActionRunning());
            updateProgressBarVisibility(toHandle.isFrecuencyActionRunning());
        });
        this.ReportState.addStateListener(toHandle -> updateReportUI(toHandle.getReportText(), toHandle.getProgressText(), toHandle.getProgressValue()));
    }

    private void updateReportUI(String areatext, String progress, double progressvalue){
        Platform.runLater(() -> {
            statelabel.setText(progress);
            LogArea.setText(areatext);
            progressbar.setProgress(progressvalue);
        });
    }
    private void updateProgressBarVisibility(boolean visibility){
        Platform.runLater(()->{
            this.progressbar.setVisible(visibility);
        });
    }
    private void updateFrecuencyActionButton(boolean disable){
        Platform.runLater(() -> frecuencyStartButton.setDisable(disable));
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
        ReportState.setReportText("");
        ActionState.setSelectedFile(chosenfile);
        ReportState.appendtoReportText("File selected: "+chosenfile.getName());
    }
    private void startFrecuency(){

        ActionState.setFrecuencyActionRunning(true);
        Task<Void> frecuencyBackgroundThread = new Task<>() {
            @Override
            protected Void call() throws Exception {
                if(interactor.executeFrecuency()){
                    interactor.afterFrecuencyExecution();
                    interactor.cleanup();
                }
                return null;
            }
        };
        frecuencyBackgroundThread.setOnSucceeded(workerStateEvent -> ActionState.setFrecuencyActionRunning(false));
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(frecuencyBackgroundThread);
        service.shutdown();
    }
    private void updateFilterUIstate(boolean t1){
        this.OptionState.setOnFilteringOption(t1);
    }
    private void updateOpenafterFinishingUIstate(boolean t1){
        this.OptionState.setOnOpeningAfterOption(t1);
    }
    private void bindComponents(){
        this.openFileButton.setOnAction(actionEvent -> openfile());
        this.frecuencyStartButton.setOnAction(actionEvent -> startFrecuency());
        this.filter.selectedProperty().addListener((observableValue, aBoolean, t1) -> updateFilterUIstate(t1));
        this.openfinishing.selectedProperty().addListener((observablevalue, aboolean, t1)->{updateOpenafterFinishingUIstate(t1);});
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setInitialState();
        bindComponents();
        addListenertoStates();
    }

    private void setInitialState(){
        this.LogArea.setEditable(false);
        this.progressbar.setVisible(false);
    }*/
}
