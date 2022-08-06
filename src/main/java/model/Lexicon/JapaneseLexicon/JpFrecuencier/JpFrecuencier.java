/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package model.Lexicon.JapaneseLexicon.JpFrecuencier;

import model.Lexicon.JapaneseLexicon.JpDecoder.JpDecoderBuilder;
import model.Lexicon.JapaneseLexicon.JpDecoder.JpDecoderType;
import model.Lexicon.JapaneseLexicon.JpDecoder.KuroDecoder;
import model.Lexicon.JapaneseLexicon.JpWord.JpWord;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
	 public List<JpWord> getTokenizedWords(){
	 	 return (List<JpWord>) decoder.get();
	 }
}
