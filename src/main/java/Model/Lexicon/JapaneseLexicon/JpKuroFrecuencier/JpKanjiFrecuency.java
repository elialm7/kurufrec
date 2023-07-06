

/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpKuroFrecuencier;


public class JpKanjiFrecuency{

	 private String REGEXKANJI = "[\\u4e00-\\u9faf]|[\\u3400-\\u4dbf]";
/*
	 private List<String> RawKanjis;
	 private List<KanjiFrecuency> encapsulatedKanji;

	 public JpKanjiFrecuency(){
	 	 this.RawKanjis = new ArrayList<>();
	 	 this.encapsulatedKanji = new ArrayList<>();
	 }
	 //gets a string and it separates into a list.
	 private List<String> putStringintoList(String mixedtext){
		  List<String> result = new ArrayList<>();
		  for(int i = 0; i < mixedtext.length(); i = mixedtext.offsetByCodePoints(i, 1)){
			   String str = new String(Character.toChars(mixedtext.codePointAt(i)));
			   result.add(str);
		  }
		  return result;
	 }
	 private  String getKanjiFilteredfromAString(String text){
	 	 StringBuilder stringBuilder = new StringBuilder();
	 	 for(int i = 0; i < text.length(); i = text.offsetByCodePoints(i, 1)){
	 	 	 String word = new String(Character.toChars(text.codePointAt(i)));
	 	 	 if(checkregex(REGEXKANJI, word)){
	 	 	 	stringBuilder.append(word);
			 }
		 }
		 return stringBuilder.toString();
	 }
	 public void addKanjiFromString(String text_with_kanji){
	 	 StringBuilder str = new StringBuilder();
	 	 str.append(this.getKanjiFilteredfromAString(text_with_kanji));
	 	 this.RawKanjis.addAll(this.putStringintoList(str.toString()));
	 }
	 public void addKanjiStringFromList(List<String> texts_withKanji){
	 	 for(String e : texts_withKanji){
	 	 	 addKanjiFromString(e);
		 }
	 }
	 public void doFrecuency(){
	 	 this.encapsulatedKanji.addAll(this.getKanjiFrecuencyList(this.RawKanjis));
	 }

	 public void doSorting(){
	 	 this.encapsulatedKanji.sort(new DefaultFrecuencyComparator());
	 }

	 public void doSorting(Comparator<KanjiFrecuency> comparator){
	 	 if(!Objects.isNull(comparator)) {
			  this.encapsulatedKanji.sort(comparator);
		 }else {
	 	 	 throw new NullPointerException("The comparator cannot be null");
		 }
	 }
	 private List<KanjiFrecuency> getKanjiFrecuencyList(List<String> kanjis) {
		  List<KanjiFrecuency> frecuencies = new ArrayList<>();
		  if (Objects.isNull(kanjis)) {
			   throw new NullPointerException("the kanji list cannot be null");
		  } else {
			   int frec = 0;
			   for (String kanji : kanjis) {
					if (frecuencies.contains(new KanjiFrecuency(kanji, 0)))
						 continue;
					frec = Collections.frequency(kanjis, kanji);
					frecuencies.add(new KanjiFrecuency(kanji, frec));
			   }
		  }
		  return frecuencies;
	 }
	 private boolean checkregex(String check, String str){
	 	 return Pattern.compile(check).matcher(str).find();
	 }

	 public List<KanjiFrecuency> getKanjiFrecuencyList(){
	 	 return this.encapsulatedKanji;
	 }

	 public List<String> getRawKanjiList(){
	 	 return this.RawKanjis;
	 }
	 */
}

