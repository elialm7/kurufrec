/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */
package App;

import Controller.MainWindowController.MainWindowController;
import View.MainViewLoader;
import javafx.application.Application;
import javafx.stage.Stage;


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
		  MainWindowController controller = new MainWindowController();
		  MainViewLoader mainwindowloader = new MainViewLoader(mainwindowStage, controller);
		  mainwindowloader.start();
	 }

}


