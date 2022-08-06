/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */
package App;

import model.Folder.MyFolder;
import model.Lexicon.JapaneseLexicon.JpFrecuencier.JpFrecuencier;
import model.Lexicon.JapaneseLexicon.JpWord.JpWord;
import model.Lexicon.JapaneseLexicon.JpWord.JpWordBuilder;
import model.Property.ConfProperty;
import model.Property.PropertyLoader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class appmain {
	 private static String propertyFile = "conf.properties";
	 private static PropertyLoader loader;
	 private static ConfProperty properties;
	 private static File jar = MyFolder.getJarFile();
	 public static void main(String args[]){
	 	 start();
	 }

	 private static void start(){
		  try {
			   File fileT = new File(MyFolder.getJarFile(), propertyFile);
			   System.out.println("#### Welcome to KuruFrec 1.0 #### ");
			   System.out.println("Verifying if the file exists...");
			   loader = new PropertyLoader(propertyFile);
			   if(!fileT.exists()){
					System.out.println("Creating the conf template in the same folder. please set it up!!!.");
					loader.createDefaulProperty();
			   }else {
					properties = loader.loadproperty();
					if (!isvalid(properties)) {
						 System.out.println("The file property is not valid. please check your wfile and wfolder. Only one should be true. and the locations should be filled properly.");
						 return;
					}
					if (!isValidData(properties)) {
						 System.out.println("The data where the fields point at are not valid. or cannot be accessed. please make sure they are valid or exists.");
						 return;
					}
					System.out.println("Making the frecuency list...");
					makeFrecuency();
					System.out.println("The frecuency list is done. it is available at :" + properties.getOutput());
					System.out.println("Author: Rodolfo Elias Ojeda almada.");
					System.out.println("Code hosted on: https://github.com/elikawa7");
			   }
		  } catch (IOException e) {
			   e.printStackTrace();
		  }
	 }

	 private static boolean isvalid(ConfProperty prop){
	 	 if(prop.isWfile() && prop.isWfolder()){
	 	 	 return false;
		 }
		 if(!prop.isWfile() && !prop.isWfolder()){
	 	 	 return false;
		 }
		 if(prop.getFolderloc().isEmpty() && prop.getFileloc().isEmpty()&&prop.getOutput().isEmpty()){
	 	 	 return false;
		 }
		 if(prop.isWfolder() && prop.getFolderloc().isEmpty()){
	 	 	 return false;
		 }
		 if(prop.isWfile() && prop.getFileloc().isEmpty()){
	 	 	 return false;
		 }
	 	 return true;
	 }


	 private static boolean isValidData(ConfProperty prop){
		  File file;
	 	 if(prop.isFromjar()){
	 	 	 if(prop.isWfile()){
	 	 	 		file =  new File(jar, prop.getFileloc());
	 	 	 		return file.exists();
			 }
			 if(prop.isWfolder()){
	 	 	 	 file = new File(jar, prop.getFolderloc());
	 	 	 	 return file.isDirectory();
			 }
			 file = new File(jar, prop.getOutput());
	 	 	 if(file.exists()){
	 	 	 	 return true;
			 }

		 }else{
				if(prop.isWfile()){
					 file = new File(prop.getFileloc());
					 return file.exists();
				}
				if(prop.isWfolder()){
					 file = new File(prop.getFolderloc());
					 return file.isDirectory();
				}
				file = new File(prop.getOutput());
				if(file.exists()){
					 return true;
				}
		 }

		 return false;
	 }


	 private static void makeFrecuency(){
		  JpFrecuencier jpFrecuencier = getFrecuencierInstance();
		  List<JpWord> frecuencyWordList = jpFrecuencier.getFrecuencyWordList();
		  Predicate<JpWord> bytype = jpWord -> {
			   return jpWord.getType().equalsIgnoreCase(JpWordBuilder.ADVERB_ENGLISH) || jpWord.getType().
					   equalsIgnoreCase( JpWordBuilder.NOUN_ENGLISH) || jpWord.getType().equalsIgnoreCase(JpWordBuilder.VERB_ENGLISH) || jpWord.getType().
					   equalsIgnoreCase(JpWordBuilder.ADJECTIVE_ENGLISH);
		  };
		  List<JpWord> frecuencyResults = frecuencyWordList.stream().filter(bytype).collect(Collectors.toList());
		  File output = new File(properties.getOutput());
		  writeintofile(output, frecuencyResults);
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
		  String header = "Index,word,reading,pronunciation,type,frecuency\n";
		  try {
			  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
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

}


