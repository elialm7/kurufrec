package core.model.JpWordingFacade;

import core.model.FileManagement.FileFolder;
import core.model.FileManagement.MyFolder;
import core.model.JpWording.JpKanjiFrecuency;
import core.model.JpWording.tok.KanjiFrecuency;
import javafx.concurrent.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JpWordingF{


	 private MyFolder folder;
	 private FileFolder filefolder;
	 private List<KanjiFrecuency> kanjis;
	 public <T> void dothread(Task<T> task){
		  ExecutorService executorService = Executors.newSingleThreadExecutor();
		  executorService.submit(task);
		  executorService.shutdown();
	 }


	 public void clear() {
	 }

	 public void setrootFolder(File folder_root) {
	 	 this.folder = new MyFolder(folder_root);
	 	 this.filefolder = new FileFolder(this.folder);
	 }

	 public boolean  loadFolderfiles(){
		   return this.filefolder.loadfiles();
	 }
	 public boolean isloaded(){
	 	 return this.filefolder.isLoaded();
	 }

	 public Task<Boolean> do_kanji_han_frec() {

	 	 Task<Boolean> booleanTask = new Task<>() {
			  @Override
			  protected Boolean call() throws Exception {
				 List<String> files_read = readfiles();
			  	 JpKanjiFrecuency kanjiFrecuency = new JpKanjiFrecuency();
			  	 updateMessage("2# Adding for kanji separation");
			  	 kanjiFrecuency.addKanjiStringFromList(files_read);
			  	 updateMessage("3# Doing frecuency of the kanjis");
			  	 kanjiFrecuency.doFrecuency();
			  	 updateMessage("4# Doing the sorting of the frecuencies");
			  	 kanjiFrecuency.doSorting();
			  	 kanjis = kanjiFrecuency.getKanjiFrecuencyList();
				   return true;
			  }

			  private List<String> readfiles(){

			  	 int total_files = filefolder.getfilestotal();
			  	 List<String> files_read = new ArrayList<>();
			  	 for(int index = 0; index < total_files; index++){
			  	 	updateMessage("1# Reading file: "+index+ " / "+total_files);
			  	 	files_read.add(filefolder.readNextFile());
				 }
				 return files_read;
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
}
