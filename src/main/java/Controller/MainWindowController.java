package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
	 @FXML
	 private Button ClearButton;

	 @FXML
	 private Button DoFrButton;

	 @FXML
	 private Label LefStatus;

	 @FXML
	 private Button OpenButton;

	 @FXML
	 private TextArea ProcessedFileTextField;

	 @FXML
	 private Button QuitButton;

	 @FXML
	 private TextArea RawFileTextField;

	 @FXML
	 private Label RightStatus;

	 @FXML
	 private Button SaveAsButton;

	 private Stage windowstage;
	 private FXMLLoader fxmlloader;
	 public MainWindowController(Stage windowstage, FXMLLoader fxmlloader){
		this.windowstage = windowstage;
		this.fxmlloader = fxmlloader;
	 }
	 public void startwindow()throws IOException {
	 	 this.fxmlloader.setController(this);
	 	 this.windowstage.setScene(new Scene(this.fxmlloader.load()));
	 	 this.windowstage.setResizable(false);
	 	 this.windowstage.setTitle("KuruFrec v1.0.0");
	 	 this.windowstage.show();
	 }
	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
		//this runs after the constructor is called...
	 }
}
