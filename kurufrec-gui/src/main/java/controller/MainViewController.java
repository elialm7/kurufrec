package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.*;
public class MainViewController implements Initializable {
    private static Logger log = LogManager.getLogger(MainViewController.class);
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
    public void setMainViewStage(Stage st) {
        this.mainViewStage = st;
    }
    public Stage getMainViewStage() {
        return mainViewStage;
    }
    public synchronized void appendtoLogArea(String newString){
        Platform.runLater(()->this.LogArea.appendText(newString+"\n"));
    }
    public synchronized void updateStateLabel(String state){
        Platform.runLater(()->this.statelabel.setText(state));
    }
    public boolean getFilterCheckState(){
        return this.filter.isSelected();
    }
    public boolean getOpenAfterFinishCheckState(){
        return this.openfinishing.isSelected();
    }
    public void setOpenFileButtonAction(EventHandler<ActionEvent> action){
        this.openFileButton.setOnAction(action);
    }
    public void setFrecuencyStartButtonAction(EventHandler<ActionEvent> action){
        this.frecuencyStartButton.setOnAction(action);
    }
    public void disableFrecuencyStartButton(boolean bool){
        this.frecuencyStartButton.setDisable(bool);
    }
    public void disableOpenfileButton(boolean bool){
        this.openFileButton.setDisable(bool);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.LogArea.setEditable(false);
    }
    public void show(){
        this.mainViewStage.setResizable(false);
        this.mainViewStage.setTitle("KuruFrec");
        this.mainViewStage.show();
    }


}
