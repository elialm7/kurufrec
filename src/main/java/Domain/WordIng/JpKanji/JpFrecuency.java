package Domain.WordIng.JpKanji;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class JpFrecuency {

	 public List<String> getOnlyKanji_hiragana_katakana(String mixedtext){
		  List<String> result = new ArrayList<>();
		  for(int i = 0; i < mixedtext.length(); i = mixedtext.offsetByCodePoints(i, 1)){
			   String str = new String(Character.toChars(mixedtext.codePointAt(i)));
			   result.add(str);

		  }
		  return result;
	 }


	 public String getAllLinesFromFile(File file) throws IOException {
		  BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		  StringBuilder stringBuffer = new StringBuilder();
		  String line;
		  while((line=bufferedReader.readLine())!=null){
		  	 stringBuffer.append(line);
		  }
	 	 return stringBuffer.toString();
	 }

	 public int getOccfromlist(List<String> list, String tofr){
	 	 return Collections.frequency(list, tofr);
	 }


	 public  List<KanjiFrecuency> getOrderedKanjiFrecuencyList(List<String> list){
	 	 String kanji;
	 	 int occ = 0;
	 	 List<KanjiFrecuency> frecuencyList = new ArrayList<>();
	 	 for(int i = 0; i<list.size(); i++){
	 	 	 kanji = list.get(i);
	 	 	 //checks if it is a japanese kanji
	 	 	 if(checkregex("[\\u4e00-\\u9faf]|[\\u3400-\\u4dbf]", kanji) && !checkregex("[\\x3400-\\x4DB5\\x4E00-\\x9FCB\\xF900-\\xFA6A]", kanji)) {
				  if (frecuencyList.contains(new KanjiFrecuency(kanji, 0)))
					   continue;
				  occ = getOccfromlist(list, kanji);
				  frecuencyList.add(new KanjiFrecuency(kanji, occ));
			 }
		 }
		frecuencyList.sort(new KanjiValueComparator(frecuencyList));
	 	 return frecuencyList;
	 }

	 public boolean checkregex(String check, String str){
	 	 return Pattern.compile(check, Pattern.CASE_INSENSITIVE).matcher(str).find();
	 }


	 public void printKanjiFrecuencyList(List<KanjiFrecuency> frecuencyList){
		Iterator<KanjiFrecuency> it = frecuencyList.iterator();
		while(it.hasNext()){
			KanjiFrecuency kanji = it.next();
			System.out.println(kanji.getKanji() + " = " + kanji.getFrecuency());
		}
	 }


	 public void printKanjiFrecuencyListonfile(List<KanjiFrecuency> list, File loc){

		  try{
			   FileWriter fw=new FileWriter(loc);
			   Iterator<KanjiFrecuency> it = list.iterator();
			   fw.write("Kanji frecuency list. \n");
			   fw.write("the amount of kanji here is: "+list.size()+"\n");
			   fw.write("Word =  Frecuency \n");
			   int counter = 1;
			   while(it.hasNext()) {
			   	 KanjiFrecuency kanji = it.next();
			   	 fw.write(counter + "->" +kanji.toString()+"\n");
			   	 counter++;
			   }
			   fw.close();
		  }catch(Exception e) {
			   System.out.println(e);
		  }
	 }
}

