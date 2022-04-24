package core.model.FileManagement;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * This class consists of methods that works with directories according to the needs of the project.
 */
public class MyFolder {

	 private String jar_folder;

	 public MyFolder(){}

	 /**
	  * this method copies file from one place to another. it is a synchronyzed method in case it is called from different threads
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
	  * This method will return a List of String of the file names that is contained in the directory given through the parameter.
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

	 /**
	  * This method loads the absolute path of the files into a List of Strings that is passed as a parameter.
	  * @param path the path that is going to be indexed
	  * @param array the array list of String where that paths indexed is gonna be added.
	  */
	 public void getFilesPathList(String path, List<String> array) {
		  File root = new File( path );
		  File[] list = root.listFiles();
		  if (list == null) return;
		  for ( File f : list ) {
			   if (f.isDirectory()) {
			   	    //recursive call
					getFilesPathList( f.getAbsolutePath(), array);
			   }
			   else {
					array.add(f.getAbsoluteFile().getAbsolutePath());
			   }
		  }
	 }

	 /**
	  * This method loads the sourcecode location and then gets its path to figure out the
	  * jar location and loads that location into the jar_jalder field.
	  */
	 private void load_jar_location(){
		  try{
			   CodeSource cs = MyFolder.class.getProtectionDomain().getCodeSource();
			   File jarfile = new  File(cs.getLocation().toURI().getPath());
			   File directoryJar = jarfile.getParentFile();
			   if(directoryJar!= null) {
					if (directoryJar.isDirectory()) {
						 jar_folder = directoryJar.getAbsolutePath();
					}
			   }else{
					throw new NullPointerException("A null reference cannot be used");
			   }
		  }catch (URISyntaxException exc){
			   //logging must go here
			   exc.getStackTrace();
		  }
	 }
	 /**
	  * This method will return you the locationg of the jar in executiong within the computer.
	  * @return A string where location of the jar in execution is
	  */
	 public String getJarPath (){
		  load_jar_location();
		  return jar_folder;
	 }
	 /**
	  *  this method return the type of the drive passed as a file. in form disk, cd drive, etc
	  * @param rootdrive the drive which we want to know what type is
	  * @return a String where the type of the drive is indicated
	  */
	 public static String getDriveType (File rootdrive){
		  FileSystemView fsv = FileSystemView.getFileSystemView();
		  return fsv.getSystemTypeDescription(rootdrive);
	 }

	 /**
	  * Check if the file passed as a string exist in the system or no.
	  * @param path the path to be checked
	  * @return true if it exist or false if it not .
	  */
	 public static boolean PathExists(String path){
	 	 return new File(path).exists();
	 }
}
