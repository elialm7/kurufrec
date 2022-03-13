package Domain.FileManagement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.*;

public class MyFolder {

	 public MyFolder(){}

	 /**
	  * this method creates a directory for the given path
	  * @param folderpath the path of the directory
	  * @return boolean value to indicate whether it was created of already exists
	  */
	 public boolean create_directory(String folderpath){
	 	 boolean wascreated = false;
		  try {
		  	 if(!Files.exists(Paths.get(folderpath))) {
				  Files.createDirectories(Paths.get(folderpath));
				  wascreated = true;
			 }
		  } catch (IOException e) {
		  	 //logging must go here
			   e.printStackTrace();
		  }
		  return wascreated;
	 }

	 /**
	  * This method given its parameters will create a file where it is indicated.
	  * @param directory the directory where the file is gonna be created.
	  * @param filename the name of the file that's gonna be created
	  * @return a boolean indicating if the creation of the file was a succes(true) or not (false)
	  */
	 public boolean create_file(String directory, String filename){
	 	 String filedir = directory + filename;
	 	 boolean wascreated = false;
		  try {
		  	 if(!Files.exists(Paths.get(filedir))) {
				  Files.createFile(Paths.get(filedir));
				  wascreated = true;
			 }
		  } catch (IOException e) {
		  	 //logging must go here
			   e.printStackTrace();
		  }
		  return wascreated;
	 }

	 /**
	  * this method copies file from one place or another. it is a synchronyzed method if it is called from different threads
	  * from the same instance.
	  * @param file_path the origin of the file containing the file already
	  * @param copy_location the final location where the file is gonna be copied
	  * @return boolean indicating that the copy file was a succes(true) or not (false)
	  */
	 public synchronized boolean copy_file(String file_path, String copy_location){
	 	 boolean wascopied = false;
		  try {
			   Files.copy(Paths.get(file_path), Paths.get(copy_location), REPLACE_EXISTING);
			   wascopied = true;
		  } catch (IOException e) {
		  	 // Logging must go here
			   e.printStackTrace();
		  }
		  return wascopied;
	 }

	 /**
	  * Given the directory containing the files, this method will return a list of strings of names
	  * @return A list of Names of the files in the folder passed through the path
	  */
	 public List<String> getFileList(String folderpath) {
		  File my_files = new File(folderpath);
		  File[] name_files = my_files.listFiles();
		  if(name_files==null){
		  	 //logging must go here
		  	 throw new NullPointerException("List of files is null, A non null, reference is required");
		  }
		  List<String> folder_content_files_name = new ArrayList<String>();
		  for (File name_file : name_files) {
			   if (name_file.isFile()) {
					folder_content_files_name.add(name_file.getName());
			   }
		  }
		return folder_content_files_name;
	 }
}
