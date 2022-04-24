package core.model.FileManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileForJp {

	 private String fileSource;
	 private List<File> filefromSource;
	 Iterator<File> fileIterator;
	 public FileForJp(String path){
	 	 this.fileSource = path;
	 	 this.filefromSource = new ArrayList<>();
	 }

	 public void loadfilesfrompath() {
		  File my_files = new File(this.fileSource);
		  File[] name_files = my_files.listFiles();
		  if(name_files==null){
			   //logging must go here
			   throw new NullPointerException("List of files is null, A non null, reference is required");
		  }
		  for (File name_file : name_files) {
			   if (name_file.isFile()) {
					this.filefromSource.add(name_file);
			   }
		  }
		  this.fileIterator = this.filefromSource.iterator();
	 }


	 public String readFile(){
	 	 String output = "No next file exists";
	 	 if(fileIterator.hasNext()) {
			  File currentfile = fileIterator.next();
			  output = getStringFromFile(currentfile);
		 }
	 	 return output;
	 }

	 public String readFile(int index_file){
	 	 if(index_file>filefromSource.size())
	 	 	 throw new IndexOutOfBoundsException("this numbers exceeds the limit of files");
	 	 return getStringFromFile(this.filefromSource.get(index_file));
	 }

	 public List<String> readAllFiles(){
	 	 List<String> strings = new ArrayList<>();
	 	 while(fileIterator.hasNext()){
	 	 	 strings.add(getStringFromFile(fileIterator.next()));
		 }
		 return strings;
	 }

	 public List<String> readAllFiles(int limit){
	 	 List<String> strings = new ArrayList<>();
	 	 int setoff = 0;
	 	 while(fileIterator.hasNext() && setoff<limit){
	 	 	 strings.add(getStringFromFile(fileIterator.next()));
	 	 	 setoff++;
		 }
		 return strings;
	 }


	 private String getStringFromFile(File file){
	 	 String out = "";
		  try {
			   FileReader fr = new FileReader(file);   //reads the file
			   BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
			   StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
			   String line;
			   while ((line = br.readLine()) != null) {
					sb.append(line);
			   }
			   fr.close();
			   br.close();
			   out = sb.toString().trim();
		  }catch(IOException e){
			   e.printStackTrace();
		  }
		  return out;
	 }
	 public int countfiles(){
	 	 return this.filefromSource.size();
	 }


	 public static void dumpAllOnFile(String output, String where) throws IOException {
		 //FileWriter fw = new FileWriter(where);
		  BufferedWriter fw = new BufferedWriter(new FileWriter(where));
		  fw.write(output);
		  fw.close();
	 }
	 public static void appendtofile(String output, String where) throws IOException {
		  BufferedWriter out = new BufferedWriter(new FileWriter(where, true));
		  out.write(output);
		  out.close();
	 }
}
