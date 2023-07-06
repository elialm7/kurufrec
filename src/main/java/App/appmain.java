/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */
package App;

import Controller.MainWindowController;
import Model.Folder.MyFolder;
import Model.Lexicon.JapaneseLexicon.JpKuroFrecuencier.JpFrecuencier;
import Model.Lexicon.JapaneseLexicon.JpWord.JpWord;
import Model.Lexicon.JapaneseLexicon.JpWord.JpWordBuilder;
import Model.Property.ConfProperty;
import Model.Property.PropertyLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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


	 private static void makeFrecuency(){
		  JpFrecuencier jpFrecuencier = getFrecuencierInstance();
		  List<JpWord> frecuencyWordList = jpFrecuencier.getFrecuencyWordList();
		  Predicate<JpWord> bytype = jpWord -> jpWord.getType().equalsIgnoreCase(JpWordBuilder.ADVERB_ENGLISH) || jpWord.getType().
				 equalsIgnoreCase( JpWordBuilder.NOUN_ENGLISH) || jpWord.getType().equalsIgnoreCase(JpWordBuilder.VERB_ENGLISH) || jpWord.getType().
				 equalsIgnoreCase(JpWordBuilder.ADJECTIVE_ENGLISH);
		  List<JpWord> frecuencyResults = frecuencyWordList.stream().filter(bytype).collect(Collectors.toList());
		  File output = getFile();
		  writeintofile(output, frecuencyResults);
	 }
	 private static File getFile(){
	 	 if(properties.isFromjar()){
	 	 	 return new File(jar, properties.getOutput());
		 }else{
	 	 	 return new File(properties.getOutput());
		 }
	 }
	 private static JpFrecuencier getFrecuencierInstance(){
	 	 File origin = null;
	 	 if(properties.isFromjar()){
	 	 	 if(properties.isWfile()){
	 	 	 	 origin = new File(jar, properties.getFileloc());
			 }
			 if(properties.isWfolder()){
	 	 	 	 origin = new File(jar, properties.getFolderloc());
			 }
		 }else {
	 	 	 if(properties.isWfile()){
	 	 	 	 origin = new File(properties.getFileloc());
			 }
			 if(properties.isWfolder()){
	 	 	 	 origin = new File(properties.getFolderloc());
			 }
		 }
		 return new JpFrecuencier(origin);
	 }

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


