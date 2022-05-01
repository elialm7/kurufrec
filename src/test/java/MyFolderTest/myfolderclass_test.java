package MyFolderTest;

import core.model.FileManagement.MyFolder;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class myfolderclass_test {



	 @Test
	 public void testinglistingFiles(){

		  MyFolder folder = new MyFolder(new File("C:\\MyFiles\\"));
		  List<String> fileslist = folder.getFilesList();
		  int counter = 0;
		  for(String a:  fileslist){
			   System.out.println((counter+1) +" -  "+ a);
			   counter++;
		  }

	 }



}
