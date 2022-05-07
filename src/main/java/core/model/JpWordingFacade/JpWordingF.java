
/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package core.model.JpWordingFacade;

import core.model.FileManagement.FileFolder;
import core.model.FileManagement.MyFolder;
import core.model.JpWording.JpKanjiFrecuency;
import core.model.JpWording.JpWordFrecuency;
import core.model.JpWording.tok.JpToken;
import core.model.JpWording.tok.KanjiFrecuency;
import javafx.concurrent.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JpWordingF{


	 private MyFolder folder;
	 private FileFolder filefolder;
	 private List<KanjiFrecuency> kanjis;
	 private List<JpToken> words;
	 public <T> void dothread(Task<T> task){
		  ExecutorService executorService = Executors.newSingleThreadExecutor();
		  executorService.submit(task);
		  executorService.shutdown();
	 }


	 public void clear() {
	 	 this.kanjis = null;
	 	 this.words = null;
	 	 if(!Objects.isNull(filefolder)){
	 	 	 filefolder.clear();
		 }
	 }

	 public void setrootFolder(File folder_root) {
	 	 this.folder = new MyFolder(folder_root);
	 	 this.filefolder = new FileFolder(this.folder);
	 }

	 public boolean  loadFolderfiles(){
		   return this.filefolder.loadfiles();
	 }
	 public boolean isloaded(){
	 	 if(!Objects.isNull(filefolder)&& !Objects.isNull(folder)) {
		 	 return this.filefolder.isLoaded();
		 }else{
	 	 	 return false;
		 }
	 }

	 public Task<Boolean> do_kanji_han_frec() {

	 	 Task<Boolean> booleanTask = new Task<>() {
			  @Override
			  protected Boolean call() throws Exception {
			  	 updateMessage("1# Readinf files");
				 List<String> files_read = filefolder.readAllFiles();
			  	 JpKanjiFrecuency kanjiFrecuency = new JpKanjiFrecuency();
			  	 updateMessage("2# Adding for kanji separation");
			  	 kanjiFrecuency.addKanjiStringFromList(files_read);
			  	 updateMessage("3# Doing frecuency of the kanjis");
			  	 kanjiFrecuency.doFrecuency();
			  	 updateMessage("4# Doing the sorting of the frecuencies");
			  	 kanjiFrecuency.doSorting();
			  	 kanjis = kanjiFrecuency.getKanjiFrecuencyList();
			  	 filefolder.clear();
				   return true;
			  }
		 };
	 	 return booleanTask;
	 }

	 public String getKanjiFrecuencyText() {
	 	 String out = "";
	 	 if(!Objects.isNull(this.kanjis)){
	 	 	 StringBuilder builder = new StringBuilder();
	 	 	 builder.append("Kanji Frecuency").append("\n");
	 	 	 builder.append("Amount of kanji: ").append(this.kanjis.size()).append("\n");
	 	 	 int counter = 0;
	 	 	 for(KanjiFrecuency kak: this.kanjis){
	 	 	 	 builder.append(counter+1).append(": ").append(kak.getKanji()).append(" -> ").append(kak.getFrecuency()).append("\n");
			 }
			 out = builder.toString();
		 }
	 	 return out;
	 }


	 public Task<Boolean> do_jp_vocab_frec() {

	 	 Task<Boolean> task = new Task<Boolean>() {
			  @Override
			  protected Boolean call() throws Exception {

				   JpWordFrecuency jp = new JpWordFrecuency();
				   updateMessage("#1 Reading files");
				   List<String> content = filefolder.readAllFiles();
				   updateMessage("2# Adding content");
				   jp.addJpString(content);
				  updateMessage("3# Tokenizing words");
				   jp.tokenizeAddedWords();
				   updateMessage("4# Doing frecuency. This may take a long time. ");
				   jp.doJpWordFrecuency();
				   updateMessage("5# Sorting the vocabulary by frecuency");
				   jp.doSorting();
				   words = jp.getFrecuencyTokens();
				   filefolder.clear();
				   return true;
			  }
		 };
	 	 return task;

	 }

	 public String getJpWordFrecuency() {
	 	 String out = "";
	 	 if(!Objects.isNull(words)){
			  StringBuilder builder = new StringBuilder();
			  builder.append("Jp Word Frecuency").append("\n");
			  builder.append("Amount of Words: ").append(this.words.size()).append("\n");
			  int counter = 0;
			  for(JpToken token: words){
				   builder.append(counter+1).append(" : ").append(token.getWord()).append(" -> ").append(token.getFrecuency()).append("\n");
				   counter++;
			  }
			  out = builder.toString();
		 }
		 return out;
	 }

	 public Task<Boolean> printOnfile(File selectedFile, String text) {

	 	 Task<Boolean> task = new Task<Boolean>() {
			  @Override
			  protected Boolean call() throws Exception {
					  BufferedWriter fw = new BufferedWriter(new FileWriter(selectedFile));
					  fw.write(text);
					  fw.close();
				   return true;
			  }
		 };
		return task;
	 }
}
