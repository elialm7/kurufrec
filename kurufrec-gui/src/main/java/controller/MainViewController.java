package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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



    private void OpenFileButton(){}

    private void StarFrecuency(){}
    private void setEvents(){


        this.openFileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEvents();
    }
}
