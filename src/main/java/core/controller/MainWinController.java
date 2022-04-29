package core.controller;

import core.model.FileManagement.FileFolder;
import core.model.FileManagement.MyFolder;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWinController implements Initializable {

	 @FXML // fx:id="Kanji_han_frec_Button"
	 private MenuItem Kanji_han_frec_Button; // Value injected by FXMLLoader

	 @FXML // fx:id="about_MenuItem"
	 private MenuItem about_MenuItem; // Value injected by FXMLLoader

	 @FXML // fx:id="clear_and_clean_TextArea"
	 private MenuItem clear_and_clean_TextArea; // Value injected by FXMLLoader

	 @FXML // fx:id="do_From_TextArea"
	 private MenuItem do_From_TextArea; // Value injected by FXMLLoader

	 @FXML // fx:id="jp_vocab_frec_button"
	 private MenuItem jp_vocab_frec_button; // Value injected by FXMLLoader

	 @FXML // fx:id="label_info"
	 private AnchorPane label_info; // Value injected by FXMLLoader

	 @FXML // fx:id="load_file_button"
	 private MenuItem load_file_button; // Value injected by FXMLLoader

	 @FXML // fx:id="load_folder_button"
	 private MenuItem load_folder_button; // Value injected by FXMLLoader

	 @FXML // fx:id="quit_MenuItem"
	 private MenuItem quit_MenuItem; // Value injected by FXMLLoader

	 @FXML // fx:id="saveAs_MenuItem"
	 private MenuItem saveAs_MenuItem; // Value injected by FXMLLoader

	 @FXML // fx:id="save_MenuItem"
	 private MenuItem save_MenuItem; // Value injected by FXMLLoader

	 @FXML // fx:id="text_area"
	 private TextArea text_area; // Value injected by FXMLLoader

	 @FXML // fx:id="openFolder_MenuItem"
	 private MenuItem openFolder_MenuItem; // Value injected by FXMLLoader

	 private Stage st;
	 private MyFolder folder;
	 private FileFolder fileFolder;
	 public MainWinController(Stage st){
	 	 this.st = st;
	 }


	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
			set_components_events();
	 }

	 /**
	  * This method sets the component events on which they are going
	  * to be called whenever an event occurs in those
	  * UI Components.
	  */
	 private void set_components_events(){
			this.Kanji_han_frec_Button.setOnAction(actionEvent -> kanji_han_frec_action());
			this.jp_vocab_frec_button.setOnAction(actionEvent -> jp_vocab_frecuency_action());
			this.openFolder_MenuItem.setOnAction(actionEvent -> OpenFolder_action());
			this.save_MenuItem.setOnAction(actionEvent -> save_action());
			this.saveAs_MenuItem.setOnAction(actionEvent -> save_as_action());
			this.quit_MenuItem.setOnAction(actionEvent -> quit_action());
			this.load_file_button.setOnAction(actionEvent -> load_file_action());
			this.load_folder_button.setOnAction(actionEvent -> load_folder_action());
			this.do_From_TextArea.setOnAction(actionEvent -> from_text_area_action());
			this.clear_and_clean_TextArea.setOnAction(actionEvent -> clear_clean_textarea_action());
			this.about_MenuItem.setOnAction(actionEvent -> about_action());
	 }

	 //does the action for the kanji/han frecuency
	 private void kanji_han_frec_action(){
	 	 if(!fileFolder.isLoaded()){
			  System.out.println("no loaded yet");
	 	 	 return;

		 }
		  Task<Boolean> dokanji = new Task<Boolean>() {
			   @Override
			   protected Boolean call() throws Exception {

					return null;
			   }
		  };

		  dokanji.runningProperty().addListener((observableValue, aBoolean, t1) -> {
		  	 //do stuff

	   });


		  dothread(dokanji);

	 }

	 // does the action for the japanese frecuency
	 private void jp_vocab_frecuency_action(){



	 }


	 //Opens the folder
	 private void OpenFolder_action(){
		  DirectoryChooser dir = new DirectoryChooser();
		  File file = dir.showDialog(st);
		  if(!Objects.isNull(file)){
		  	 if(file.isDirectory()){
		  	 	 this.folder = new MyFolder(file.getAbsolutePath());
			 }
		  }
	 }

	private void save_action(){

		//ui no defined yet.


	}
	private void save_as_action(){
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Open Resource File");
		 fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
		 File selectedFile = fileChooser.showSaveDialog(st);
		 if(!Objects.isNull(selectedFile)){
			  System.out.println(selectedFile.getAbsolutePath());
		 }
	}
	private void quit_action(){

		 Platform.exit();

	}

	private void load_file_action(){
	 	 //no ui defined yet
	}

	private void load_folder_action(){
		fileFolder = new FileFolder(this.folder);
		fileFolder.loadfiles();
	}
	private void from_text_area_action(){

	 }
	 private void clear_clean_textarea_action(){
	 	 fileFolder.clear();
	 	 this.text_area.clear();
	 }

	 private void about_action(){


	 }


	 private <T> void dothread(Task<T> task){
		  ExecutorService executorService = Executors.newSingleThreadExecutor();
		  executorService.submit(task);
		  executorService.shutdown();
	 }


}
