package Model.Folder;


import java.io.File;
import java.util.Objects;

public class FileController {
	 private File selectedFile;
	 private boolean loaded = false;
	 private static FileController instance = null;
	 private FileController(){}
	 public static FileController getInstance(){
	 	 if(Objects.isNull(instance)){
	 	 	 instance = new FileController();
		 }
		 return instance;
	 }
	 public void loadFile(File newfile){
	 	 this.selectedFile = newfile;
	 	 this.loaded = true;
	 }
	 public String getFilename(){
	 	 return this.selectedFile.getName();
	 }

	 public void clear(){
	 	 this.selectedFile = null;
	 	 this.loaded = false;
	 }

	 public String getFileText(){
	 	 return MyFolder.getStringFromFile(this.selectedFile);
	 }
	 public File getSelectedFile(){
	 	 return this.selectedFile;
	 }

	 public boolean isloaded() {
		  return loaded;
	 }
}
