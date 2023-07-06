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

import java.io.*;


public class appmain extends Application {
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


/*



	 public static void writeintofile(File output, List<JpWord> words) {
	 	 String meta = "the amount of words: "+words.size()+"\n";
	 	 String header = "Index,Word,Reading,Pronunciation,Type,Frecuency,Romaji\n";
		  try {
			  BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8));
			  bufferedWriter.write(meta);
			  bufferedWriter.write(header);
			  Iterator<JpWord> it = words.iterator();
			  int counter = 1;
			   while(it.hasNext()){
			   	 	JpWord word = it.next();
					bufferedWriter.write(counter+","+word.toString()+"\n");
					bufferedWriter.flush();
					counter++;
			   }
			   bufferedWriter.close();
		  } catch (IOException e) {
			   e.printStackTrace();
		  }
	 }
*/

}


