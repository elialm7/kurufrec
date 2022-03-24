package Domain.WordIng.JpKanji;

import java.util.Comparator;
import java.util.List;

public class  KanjiValueComparator implements Comparator<KanjiFrecuency> {
	 List<KanjiFrecuency> base;

	 public KanjiValueComparator(List<KanjiFrecuency> base) {
		  this.base = base;
	 }

	 @Override
	 public int compare(KanjiFrecuency o1, KanjiFrecuency o2) {
	 	 if(o1.getFrecuency()>o2.getFrecuency()){
	 	 	 return -1;
		 }else if(o1.getFrecuency()< o2.getFrecuency()){
	 	 	 return 1;
		 }else{
	 	 	 return 0;
		 }
	 }
}