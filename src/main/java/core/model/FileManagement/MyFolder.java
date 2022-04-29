package core.model.FileManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class consists of methods that works with directories according to the needs of the project.
 */
public class MyFolder {

	 //private String jar_folder;
	private String pathfolder;
	 public MyFolder(){}

	 public MyFolder(String folder){
	 	 this.pathfolder = folder;
	 }

	 public List<String> getFilesList(){
	 	 return getFilesList(this.pathfolder);
	 }
	 public List<String> getFilesList(String folder){
	 	 List<String> all_files = new ArrayList<>();
	 	 getFolderFilesList(folder, all_files);
	 	 return all_files;
	 }
	 private void getFolderFilesList(String path, List<String> arraylist) {
		  File root = new File( path );
		  File[] list = root.listFiles();
		  if (Objects.isNull(list)) return;
		  for ( File f : list ) {
			   if (f.isDirectory()) {
					getFolderFilesList( f.getAbsolutePath(), arraylist);
			   } else {
					arraylist.add(f.getAbsoluteFile().getAbsolutePath());
			   }
		  }
	 }
}
