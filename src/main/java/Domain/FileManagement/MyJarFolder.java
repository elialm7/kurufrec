package Domain.FileManagement;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class MyJarFolder {

	 private String jar_folder;

	 public MyJarFolder(){
	 	 super();
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

	 public String getJar_folder_path (){
	 	 load_jar_location();
	 	 return jar_folder;
	 }
}
