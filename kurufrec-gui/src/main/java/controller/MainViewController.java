package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private TextArea LogArea;

    @FXML
    private Button frecuencyStartButton;

    @FXML
    private Button openFileButton;

    @FXML
    private Label titleLabel;

    private Stage mainViewStage;

    public void setMainViewStage(Stage st){
        this.mainViewStage = st;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
