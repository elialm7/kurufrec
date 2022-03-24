package JpFrecuencyTest;

import Domain.WordIng.JpKanji.JpFrecuency;
import Domain.WordIng.JpKanji.KanjiFrecuency;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class jpfrecuencyTest {

	 @Test
	 void allworkintogether(){

		  String loc = "C:\\Users\\Rodolfo Elias\\Desktop\\jpcab.txt";
		  String locfrecuency = "C:\\Users\\Rodolfo Elias\\Desktop\\finalfrecuency.txt";
		  try {
			   JpFrecuency jp = new JpFrecuency();
			   System.out.println("Reading the file and laoding... ");
			   List<String> listkanji= jp.getOnlyKanji_hiragana_katakana(jp.getAllLinesFromFile(new File(loc)));
			   System.out.println("Sorting the List... ");
			   List<KanjiFrecuency> kanjiFrecuency = jp.getOrderedKanjiFrecuencyList(listkanji);
			   System.out.println("Printing the list ... ");
			   System.out.println("Size of the list : " + kanjiFrecuency.size());
			   jp.printKanjiFrecuencyList(kanjiFrecuency);
			   System.out.println("Printing the list on file... ");
			   jp.printKanjiFrecuencyListonfile(kanjiFrecuency, new File(locfrecuency));
			   System.out.println("Success... ");
		  } catch (IOException e) {
			   e.printStackTrace();
		  }
	 }
}
