/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */
package App;

import Controller.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;


public class Appmain extends Application {
	 private Stage mainwindowStage;
	 public static void main(String args[]){
		launch(args);
	 }
	 @Override
	 public void start(Stage stage) throws Exception {
		this.mainwindowStage = stage;
		this.StartMainWindow();
	 }
	 private void StartMainWindow(){
		  try {
		  		FXMLLoader mainwindowloader = new FXMLLoader(getClass().getResource("/main/mainwindow.fxml"));
		  		MainWindowController windowController = new MainWindowController(this.mainwindowStage, mainwindowloader);
			    windowController.startwindow();
		  } catch (IOException e) {
			   e.printStackTrace();
			   //some sort of logging must be implemented
		  }
	 }

}


