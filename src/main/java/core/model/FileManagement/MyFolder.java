package core.model.FileManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class consists of methods that works with directories according to the needs of the project.
 */
public class MyFolder {

	private File rootfolder;
	public MyFolder(){}

	 public MyFolder(String folder){
	 	 this.rootfolder = new File(folder);
	 }

	 public MyFolder(File file){
	 	 this.rootfolder = file;
	 }

	 public List<String> getFilesList(){
		  List<String> all_files = new ArrayList<>();
		  getFolderFilesList(this.rootfolder, all_files);
		  return all_files;
	 }
	 private void getFolderFilesList(File path, List<String> arraylist) {
		  File root = path;
		  File[] list = root.listFiles();
		  if (Objects.isNull(list)) return;
		  for ( File f : list ) {
			   if (f.isDirectory()) {
					getFolderFilesList(f, arraylist);
			   } else {
					arraylist.add(f.getAbsoluteFile().getAbsolutePath());
			   }
		  }
	 }

	 public List<File> getFilesList_(){
		  List<File> files = new ArrayList<>();
		  List<String> path_strings = getFilesList();
		  File file;
		  for(String pathfile: path_strings){
			   file = new File(pathfile);
			   files.add(file);
		  }
		  return files;
	 }
}
