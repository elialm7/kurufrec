
/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package core.controller;

import core.model.JpWordingFacade.JpWordingF;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
	 private Label label_info; // Value injected by FXMLLoader

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

	 private JpWordingF jputil;

	 private File folder_root;
	 public MainWinController(Stage st){
	 	 this.st = st;
	 	 this.jputil = new JpWordingF();
	 }


	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
			set_components_events();
			label_info.setText("Welcome to KuruFrec tool beta ");
			this.do_From_TextArea.setVisible(false);
			this.do_From_TextArea.setDisable(false);
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
	 	 if(jputil.isloaded()){
			 Task<Boolean> kanjitask = jputil.do_kanji_han_frec();
			 this.label_info.setText("Kanji operation set up successfully.");
			 this.label_info.textProperty().bind(kanjitask.messageProperty());
			 kanjitask.setOnSucceeded(workerStateEvent -> Platform.runLater(() -> text_area.setText(jputil.getKanjiFrecuencyText())));
			 jputil.dothread(kanjitask);
		}else{
	 	 	 this.label_info.setText("The files haven't been loaded. :(");
		 }
	 }

	 // does the action for the japanese frecuency
	 private void jp_vocab_frecuency_action(){

	 	 if(jputil.isloaded()){
	 	 	 Task<Boolean> jptask = jputil.do_jp_vocab_frec();
	 	 	 this.label_info.setText("Jp Word operation task set up succesfully");
	 	 	 this.label_info.textProperty().bind(jptask.messageProperty());
	 	 	 jptask.setOnSucceeded(workerStateEvent -> Platform.runLater(() -> text_area.setText(jputil.getJpWordFrecuency())));
	 	 	 jputil.dothread(jptask);
		 }else{
	 	 	 this.label_info.setText("The files haven't been loaded yet. :(");
		 }
	 }


	 //Opens the folder
	 private void OpenFolder_action(){
		  DirectoryChooser dir = new DirectoryChooser();
		  File file = dir.showDialog(st);
		  if(!Objects.isNull(file)){
		  	 if(file.isDirectory()){
		  	 	folder_root = file;
			 }
		  }
	 }

	private void save_action(){

		//ui no defined yet.


	}
	private void save_as_action(){
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Save File");
		 fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
		 File selectedFile = fileChooser.showSaveDialog(st);
		 if(!text_area.getText().isEmpty()) {
			  Task<Boolean> printingTaks = jputil.printOnfile(new File(selectedFile.getAbsolutePath()), text_area.getText());
			  printingTaks.setOnSucceeded(workerStateEvent -> label_info.setText("The file has been written succesfully"));
			  jputil.dothread(printingTaks);
		 }else{
		 	 label_info.setText("Please, Write something in the Text area to save. or do one the Tools options.");
		 }
	}
	private void quit_action(){
		 Platform.exit();
	}

	private void load_file_action(){
	 	 //no ui defined yet
	}

	private void load_folder_action(){
	 	 if(!Objects.isNull(folder_root)){
	 	 	 this.jputil.setrootFolder(this.folder_root);
	 	 	 boolean load_result = this.jputil.loadFolderfiles();
	 	 	 if(load_result){
	 	 	 	 this.label_info.setText("Files Loaded -- Success");
			 }else{
	 	 	 	 this.label_info.setText("Files Not loaded -- Failed");
			 }
		 }else{
	 	 	 this.label_info.setText("Folder root is null.");
		 }
	}
	private void from_text_area_action() {
		 String text_from_area = this.text_area.getText();

	}
	 private void clear_clean_textarea_action(){
	 	 this.jputil.clear();
	 	 this.text_area.clear();
	 }

	 private void about_action(){
		  Alert alert = new Alert(Alert.AlertType.INFORMATION);
		  alert.setTitle("About");
		  alert.setHeaderText("Information About KuruFrec tool beta");
		  alert.setContentText("This software was developed by Elias Ojeda.\n" +
				  "This software makes a frecuency list for japanese words and Japanese kanji and chinese hanzi.\n" +
				  "For the tokenization part I used the Kuromoji library.\n"+
		  "This is just a wrapped up of the code I had already developed for my own needs.\n" +
				  "therefore this version is not well coded or designed.");
		  alert.initOwner(st);
		  alert.showAndWait();
	 }
}
