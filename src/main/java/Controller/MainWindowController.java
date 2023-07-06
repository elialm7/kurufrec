package Controller;

import Model.Folder.FileController;
import Model.Lexicon.JapaneseLexicon.JpKuroFrecuencier.JpFrecuencier;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	 @FXML
	 private CheckBox checkFromTextArea;
	 @FXML
	 private ProgressBar ProcessProgressBar;

	 private Stage windowstage;
	 private FXMLLoader fxmlloader;
	 private FileController fileController;
	 public MainWindowController(Stage windowstage, FXMLLoader fxmlloader){
		this.windowstage = windowstage;
		this.fxmlloader = fxmlloader;
	 }
	 public void startwindow()throws IOException {
	 	 this.fxmlloader.setController(this);
	 	 this.windowstage.setScene(new Scene(this.fxmlloader.load()));
	 	 this.windowstage.setResizable(false);
	 	 this.windowstage.setTitle("KuruFrec v2.0.0");
	 	 this.windowstage.show();
	 }
	 private void loaddependecies(){
	 	 fileController = FileController.getInstance();
	 }
	 private void setInitialstates(){
	 	 this.OpenButton.setDisable(false);
	 	 this.QuitButton.setDisable(false);
	 	 this.ClearButton.setDisable(false);
	 	 this.DoFrButton.setDisable(true);
	 	 this.SaveAsButton.setDisable(true);
	 	 this.RawFileTextField.setDisable(true);
	 	 this.ProcessedFileTextField.setDisable(true);
	 	 this.LefStatus.setText("");
	 	 this.RightStatus.setText("");
	 	 this.ProcessProgressBar.setVisible(false);
	 	 this.checkFromTextArea.setSelected(false);
	 }
	 private void setButtonsEvents(){
	 	 this.OpenButton.setOnAction(actionEvent -> OpenFileButtonAction());
	 	 this.QuitButton.setOnAction(actionEvent -> QuitButtonAction());
	 	 this.ClearButton.setOnAction(actionEvent -> ClearButtonAction());
	 	 this.DoFrButton.setOnAction(actionEvent -> DoFrecuencyButtonAction());
	 	 this.SaveAsButton.setOnAction(actionEvent -> SaveAsButtonAction());
	 	 this.checkFromTextArea.selectedProperty().addListener((observableValue, aBoolean, t1) -> CheckBoxListener(t1));
	 }
	 private void setUIStateAfterFileLoaded(){
		  this.OpenButton.setDisable(false);
		  this.QuitButton.setDisable(false);
		  this.ClearButton.setDisable(false);
		  this.DoFrButton.setDisable(false);
		  this.SaveAsButton.setDisable(true);
		  this.RawFileTextField.setDisable(false);
		  this.ProcessedFileTextField.setDisable(true);
	 }
	 private void setUIStateAfterFrecuencyloaded(){
		  this.OpenButton.setDisable(false);
		  this.QuitButton.setDisable(false);
		  this.ClearButton.setDisable(false);
		  this.DoFrButton.setDisable(false);
		  this.SaveAsButton.setDisable(false);
		  this.RawFileTextField.setDisable(false);
		  this.ProcessedFileTextField.setDisable(false);
		  UpdateLeftStatus("");
	 }
	 private void blockUIoptions(){
		  this.OpenButton.setDisable(true);
		  this.QuitButton.setDisable(true);
		  this.ClearButton.setDisable(true);
		  this.DoFrButton.setDisable(true);
		  this.SaveAsButton.setDisable(true);
		  this.RawFileTextField.setDisable(true);
		  this.ProcessedFileTextField.setDisable(true);
	 }
	 private void UpdateLeftStatus(String context){
	 	 this.LefStatus.setText(context);
	 }
	 private void UpdateRightStatus(String context){
	 	 this.RightStatus.setText(context);
	 }
	 private void UpdateRawTextField(String text){
	 	 this.RawFileTextField.setText(text);
	 }
	 private void UpdateProcessedTextField(String text){
	 	 this.ProcessedFileTextField.setText(text);
	 }
	 private void UpdateVisibiltyProgressBar(boolean visibility){
	 	 this.ProcessProgressBar.setVisible(visibility);
	 }
	 private void OpenFileButtonAction(){
		  //Open the file dialog and load the selected file onto the controller.
		  FileChooser fileChooser = new FileChooser();
		  File selectedFile =  fileChooser.showOpenDialog(this.windowstage);
		  if(Objects.isNull(selectedFile))return;
		  this.fileController.loadFile(selectedFile);
		  setUIStateAfterFileLoaded();
		  UpdateLeftStatus("File Loaded");
		  UpdateRightStatus(this.fileController.getFilename() + " was loaded");
		  UpdateRawTextField(this.fileController.getFileText());
	 }
	 private void QuitButtonAction(){
		  Platform.exit();
	 }
	 private void CheckBoxListener(boolean state){
	 	 if(state){
	 	 	 UpdateLeftStatus("Text from TextArea Preferred...");
	 	 	 UpdateRightStatus("");
	 	 	 this.RawFileTextField.setDisable(false);
	 	 	 this.DoFrButton.setDisable(false);
		 }else{
	 	 	 if(!fileController.isloaded()){
				  UpdateLeftStatus("File to be Loaded Preferred...");
				  this.DoFrButton.setDisable(true);
	 	 	 	 return;
	 	 	 }
	 	 	 UpdateLeftStatus("File Loaded Preferred...");
	 	 	 UpdateRightStatus(this.fileController.getFilename() + " is loaded");
		 }
	 }
	 private void ClearButtonAction(){
	 	 Alert clearAlert = new Alert(Alert.AlertType.WARNING);
	 	 clearAlert.setContentText("The loaded file is going to be cleared.!!!");
	 	 UpdateLeftStatus("WARNING!!!");
	 	 UpdateRightStatus("");
	 	 clearAlert.showAndWait();
	 	 this.fileController.clear();
	 	 UpdateRawTextField("");
	 	 UpdateProcessedTextField("");
	 	 setInitialstates();
	 }
	 private void DoFrecuencyButtonAction(){
	 	 if(this.checkFromTextArea.isSelected() && this.RawFileTextField.getText().isEmpty()){
	 	 	 Alert EmptyRawTextArea = new Alert(Alert.AlertType.WARNING);
	 	 	 EmptyRawTextArea.setContentText("The Text area preferred is empty!!!");
	 	 	 EmptyRawTextArea.showAndWait();
	 	 	 UpdateLeftStatus("Hint: choose a file or fill the text area ...");
	 	 	 return;
		 }

	 	  blockUIoptions();
		  Task<String> frecuencyTask = new Task<String>() {
			   @Override
			   protected String call() throws Exception {
			   	 JpFrecuencier frecuencier;
			   	 if(checkFromTextArea.isSelected()){
			   	 	 frecuencier = new JpFrecuencier(RawFileTextField.getText());
				 }else{
			   	 	 frecuencier = new JpFrecuencier(fileController.getSelectedFile());
				 }
					return frecuencier.getFrecuencyWordListasString();
			   }
		  };
		  frecuencyTask.runningProperty().addListener((observableValue, aBoolean, t1) -> {
			  if(t1){
			   UpdateRightStatus("Frecuency List Process Running...");
			  }else{
			   UpdateRightStatus("Finished!!!");
			  }
			  UpdateVisibiltyProgressBar(t1);
		  });
		  frecuencyTask.setOnSucceeded(workerStateEvent -> {
				  setUIStateAfterFrecuencyloaded();
				  UpdateVisibiltyProgressBar(false);
				  String result = frecuencyTask.getValue();
				  UpdateProcessedTextField(result);
		  });
		  ExecutorService threadservice = Executors.newSingleThreadExecutor();
		  threadservice.submit(frecuencyTask);
		  threadservice.shutdown();
	 }
	 private void SaveAsButtonAction(){




	 }

	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
		  setInitialstates();
		  setButtonsEvents();
		  loaddependecies();
	 }
}
