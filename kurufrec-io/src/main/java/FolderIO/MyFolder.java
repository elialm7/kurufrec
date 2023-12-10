/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package FolderIO;


public class MyFolder {
	 //returns empty if there are no files in the folder
/*
	 public static List<File> getFilePathList(File rootfolder){
		  List<File> all_files = new ArrayList<>();
		  getFolderFilesList(rootfolder, all_files); // a recursive method which laods the path of files in the given array.
		 return all_files;
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
			logger.fatal("An excepcion ocurrer when the file was being read.", e);
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
		  	 logger.fatal("An exception occurred when getting the jafile", e);
		  }
		  return jarfile;
	 }

	 public static void writeOnFile(String result, File output){
		 try {
			 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8));
			 bufferedWriter.write(result);
			 bufferedWriter.close();
		 } catch (IOException e) {
			 throw new KuruException(e.getMessage(), ErrorType.EXTERNAL);
         }
     }*/
}
