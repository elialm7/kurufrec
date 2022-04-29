package MyFolderTest;

import core.model.FileManagement.MyFolder;
import org.junit.Test;

import java.util.List;

public class myfolderclass_test {



	 @Test
	 public void testinglistingFiles(){

		  MyFolder folder = new MyFolder();
		  List<String> fileslist = folder.getFilesList("C:\\MyFiles\\");
		  int counter = 0;
		  for(String a:  fileslist){
			   System.out.println((counter+1) +" -  "+ a);
			   counter++;
		  }

	 }



}
