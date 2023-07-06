/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpKuroFrecuencier;

import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Builder.JpDecoderBuilder;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Type.JpDecoderType;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.KuroDecoder;
import Model.Lexicon.JapaneseLexicon.JpWord.JpWord;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JpFrecuencier {
	 private KuroDecoder decoder;

	 public JpFrecuencier(File folder){
	 	 if(folder.isFile()){
	 	 	 decoder = JpDecoderBuilder.BuildDecoder(JpDecoderType.FILE_TYPE);
		 }else if (folder.isDirectory()) {
			  decoder = JpDecoderBuilder.BuildDecoder(JpDecoderType.FOLDER_TYPE);
		 }
	 	 decoder.set(folder);
	 }
	 public JpFrecuencier(String text){
	 	 decoder = JpDecoderBuilder.BuildDecoder(JpDecoderType.TEXT_TYPE);
	 	 decoder.set(text);
	 }
	 public List<JpWord> getFrecuencyWordList(){
	 	 List<JpWord> tokenizedwords = this.getTokenizedWords();
	 	 List<JpWord> FrecuencyWords = new ArrayList<>();
	 	 int frecuency;
	 	 int index=0;
	 	 for(JpWord jpWord:tokenizedwords){
	 	 	 if(FrecuencyWords.contains(jpWord))
	 	 	 	 continue;
	 	 	 frecuency = Collections.frequency(tokenizedwords, jpWord);
	 	 	 jpWord.setFrecuency(frecuency);
	 	 	 jpWord.setIndex(String.valueOf(index));
	 	 	 FrecuencyWords.add(jpWord);
		 }
		 FrecuencyWords.sort((o1, o2) -> Integer.compare(o2.getFrecuency(), o1.getFrecuency()));
	 	 return FrecuencyWords;
	 }
	 public String getFrecuencyWordListasString(){
	 	 StringBuilder strbuilder = new StringBuilder();
	 	 List<JpWord> words = getFrecuencyWordList();
	 	 String meta = "Words: " +words.size()+"\n";
	 	 String header = "Index,Word,Reading,Pronunciation,Type,Frecuency,Romaji\n";
	 	 strbuilder.append(meta).append(header);
	 	 Iterator<JpWord> it = words.iterator();
	 	 int counter = 1;
	 	 while(it.hasNext()){
			   JpWord word = it.next();
			   strbuilder.append(counter+","+word.toString()+"\n");
			   counter++;
		  }
		  return strbuilder.toString();
	 }
	 public List<JpWord> getTokenizedWords(){
	 	 return (List<JpWord>) decoder.get();
	 }
}
