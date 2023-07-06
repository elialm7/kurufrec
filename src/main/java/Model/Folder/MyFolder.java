/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Folder;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MyFolder {
	 //returns empty if there are no files in the folder
	 public static Optional<List<File>> getFilePathList(File rootfolder){
		  List<File> all_files = new ArrayList<>();
		  getFolderFilesList(rootfolder, all_files); // a recursive method which laods the path of files in the given array.
		  if(all_files.size()>0){
		  	 return Optional.of(all_files);
		  }
		  return Optional.empty();
	 }
	 private static void getFolderFilesList(File path, List<File> arraylist) {
		  File root = path;
		  File[] list = root.listFiles();
		  if (Objects.isNull(list)) return;
		  for ( File f : list ) {
			   if (f.isDirectory()) {
					getFolderFilesList(f, arraylist);
			   } else {
					arraylist.add(f.getAbsoluteFile());
			   }
		  }
	 }

	 public static String getStringFromFile(File file){
		  StringBuffer sb = new StringBuffer();
		  try {
			   BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			   String line;
			   while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
			   }
			   br.close();
		  }catch(IOException e){
			e.printStackTrace();
		  }
		  return sb.toString();
	 }
	 public static String getStringFromFiles(File[] files){
		  StringBuilder strbuilder = new StringBuilder();
		  for(File file: files){
			   strbuilder.append(getStringFromFile(file));
		  }
		  return strbuilder.toString();
	 }

	 public static File getJarFile(){
	 	 File jarfile = null;
		  try {
			   CodeSource cs = MyFolder.class.getProtectionDomain().getCodeSource();
			   jarfile= new  File(cs.getLocation().toURI().getPath());
			   return jarfile.getParentFile();
		  } catch (URISyntaxException e) {
			   e.printStackTrace();
		  }
		  return jarfile;
	 }
}
