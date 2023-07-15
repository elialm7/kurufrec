package Controller.MainWindowController;

import Model.Folder.FileController;
import Model.Lexicon.JapaneseLexicon.JpKuroFrecuencier.JpFrecuencier;
import Model.Utilities.UIRepository.UITextRepository;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
	 @FXML
	 private Button AbtButton;

	 private Stage windowStage;
	 private FileController fileController;

	 public MainWindowController(){

	 }
	 public void setStage(Stage stage){
	 	 windowStage = stage;
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
	 	 this.AbtButton.setOnAction(actionEvent -> AbtButtonAction());
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
		  File selectedFile =  fileChooser.showOpenDialog(this.windowStage);
		  if(Objects.isNull(selectedFile))return;
		  this.fileController.loadFile(selectedFile);
		  setUIStateAfterFileLoaded();
		  UpdateLeftStatus(UITextRepository.FileLoadedText);
		  UpdateRightStatus(this.fileController.getFilename() + UITextRepository.isloadedText);
		  UpdateRawTextField(this.fileController.getFileText());
	 }
	 private void QuitButtonAction(){
		  Platform.exit();
	 }
	 private void AbtButtonAction(){
			Alert Info= new Alert(Alert.AlertType.INFORMATION);
			Info.setHeaderText(UITextRepository.AboutTextHeader);
			Info.setContentText(UITextRepository.AboutTextContent);
			Info.showAndWait();
	 }
	 private void CheckBoxListener(boolean state){
	 	 if(state){
	 	 	 UpdateLeftStatus(UITextRepository.TextAreaPreferred);
	 	 	 UpdateRightStatus("");
	 	 	 this.RawFileTextField.setDisable(false);
	 	 	 this.DoFrButton.setDisable(false);
		 }else{
	 	 	 if(!fileController.isloaded()){
				  UpdateLeftStatus(UITextRepository.FileTobeLoadedPreferred);
				  this.DoFrButton.setDisable(true);
	 	 	 	 return;
	 	 	 }
	 	 	 UpdateLeftStatus(UITextRepository.LoadedFilePreferred);
	 	 	 UpdateRightStatus(this.fileController.getFilename()+UITextRepository.isloadedText);
		 }
	 }
	 private void ClearButtonAction(){
	 	 Alert clearAlert = new Alert(Alert.AlertType.WARNING);
	 	 clearAlert.setContentText(UITextRepository.ClearAlertContentText);
	 	 UpdateLeftStatus(UITextRepository.WarningText);
	 	 UpdateRightStatus("");
	 	 clearAlert.showAndWait();
	 	 this.fileController.clear();
	 	 UpdateRawTextField("");
	 	 UpdateProcessedTextField("");
	 	 setInitialstates();
	 }
	 private String FrecuencyTaskOperation(){
		  JpFrecuencier frecuencier;
		  if(checkFromTextArea.isSelected()){
			   frecuencier = new JpFrecuencier(RawFileTextField.getText());
		  }else{
			   frecuencier = new JpFrecuencier(fileController.getSelectedFile());
		  }
		  return frecuencier.getFrecuencyWordListAsString();
	 }

	 private void UpdateFrecuencyTaskUI(boolean runningstate){
		  if(runningstate){
			   UpdateRightStatus(UITextRepository.FrecuencyListProcessText);
		  }else{
			   UpdateRightStatus(UITextRepository.FinishedText);
		  }
		  UpdateVisibiltyProgressBar(runningstate);
	 }
	 private void UpdateWritingOnFileTask(boolean runningstate){
		  if(runningstate){
			   UpdateRightStatus(UITextRepository.WritingOnFileText);
		  }else{
			   UpdateRightStatus(UITextRepository.FinishedText);
		  }
		  UpdateVisibiltyProgressBar(runningstate);
	 }
	 private void setFrecuencyTaskUIOnSucceed(Task<String> frecuencyTask){
		  setUIStateAfterFrecuencyloaded();
		  UpdateVisibiltyProgressBar(false);
		  String result = frecuencyTask.getValue();
		  UpdateProcessedTextField(result);
	 }

	 private boolean WriteOnFile(File selectedFile){
		  try {
			   BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(selectedFile), StandardCharsets.UTF_8));
			   bufferedWriter.write(ProcessedFileTextField.getText());
			   bufferedWriter.close();
			   return true;
		  } catch (IOException e) {
			   e.printStackTrace();
			   return false;
		  }
	 }

	 private void DoFrecuencyButtonAction(){
	 	 if(this.checkFromTextArea.isSelected() && this.RawFileTextField.getText().isEmpty()){
	 	 	 Alert EmptyRawTextArea = new Alert(Alert.AlertType.WARNING);
	 	 	 EmptyRawTextArea.setContentText(UITextRepository.TextAreaEmptyText);
	 	 	 EmptyRawTextArea.showAndWait();
	 	 	 UpdateLeftStatus(UITextRepository.HintChooseFileFillText);
	 	 	 return;
		 }
	 	  blockUIoptions();
		  Task<String> frecuencyTask = new Task<>() {
			   @Override
			   protected String call() throws Exception {
					return FrecuencyTaskOperation();
			   }
		  };
		  frecuencyTask.runningProperty().addListener((observableValue, aBoolean, runningstate) ->UpdateFrecuencyTaskUI(runningstate) );
		  frecuencyTask.setOnSucceeded(workerStateEvent ->setFrecuencyTaskUIOnSucceed(frecuencyTask));
		  CallThreadExecutor(frecuencyTask);
	 }
	 private void SaveAsButtonAction(){

	 	 FileChooser SaveAs = new FileChooser();
	 	 File selectedFile = SaveAs.showSaveDialog(this.windowStage);
	 	 if(Objects.isNull(selectedFile))return;
	 	 Task<Boolean> savetotask = new Task<>() {
			  @Override
			  protected Boolean call() throws Exception {
				   return WriteOnFile(selectedFile);
			  }
		 };
	 	 savetotask.runningProperty().addListener((observableValue, aBoolean, runningState) -> UpdateWritingOnFileTask(runningState));
	 	 savetotask.setOnSucceeded(workerStateEvent -> UpdateLeftStatus(UITextRepository.PathText+selectedFile.getAbsolutePath()));
	 	 CallThreadExecutor(savetotask);
	 }

	 private void CallThreadExecutor(Task tasktobeCalled){
		  ExecutorService threadservice = Executors.newSingleThreadExecutor();
		  threadservice.submit(tasktobeCalled);
		  threadservice.shutdown();
	 }

	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
		  setInitialstates();
		  setButtonsEvents();
		  loaddependecies();
	 }
}
