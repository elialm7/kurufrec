/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Lexicon.JapaneseLexicon.JpKuroFrecuencier;

import Model.Entities.LexiconEntities.JpCharacter.JpCharacterToken;
import Model.Entities.LexiconEntities.JpWord.JpWord;
import Model.Entities.LexiconEntities.JpWord.JpWordBuilder;
import Model.Lexicon.JpLexer.JpLexer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JpFrecuencier {
	 private String REGEXKANJI = "[\\u4e00-\\u9faf]|[\\u3400-\\u4dbf]";
	 private String REGEXKANJI_HIRAGANA_KATAKANA = "[\\x{3041}-\\x{3096}\\x{30A0}-\\x{30FF}\\x{3400}-\\x{4DB5}\\x{4E00}-\\x{9FCB}\\x{F900}-\\x{FA6A}\\x{2E80}-\\x{2FD5}\\x{FF5F}-\\x{FF9F}\\x{3000}-\\x{303F}\\x{31F0}-\\x{31FF}\\x{3220}-\\x{3243}\\x{3280}-\\x{337F}]";
	 private JpLexer lexer;
	 private File sourceFile;
	 public JpFrecuencier(File sourceFile){
		 this.sourceFile = sourceFile;
		 lexer = new JpLexer();
	 }
	 public List<JpWord> getFrecuencyWordList(){
	 	 List<JpWord> tokenizedwords = JpWordBuilder.fromTokens(this.lexer.tokenize(this.sourceFile));
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
	 private List<JpCharacterToken> accumulate(List<JpWord> words){
	 	 List<JpCharacterToken> AccJpTokens = new ArrayList<>();
	 	 for(JpWord word: words){
	 	 	 AccJpTokens.addAll(JpWordBuilder.getCharactersTokenfromWord(word));
		 }
		 return AccJpTokens;
	 }
	 //probably really slow...
	 public List<JpCharacterToken> getFrecuencyKanjiList(){
	 	 List<JpWord> tokenizedkanjiswords = JpWordBuilder.fromTokens(this.lexer.tokenize(this.sourceFile));
	 	 List<JpCharacterToken> accumalatedtokens = accumulate(tokenizedkanjiswords);
	 	 List<JpCharacterToken> frecuenciedTokens = new ArrayList<>();
	 	 int frecuency;
	 	 for(JpCharacterToken token: accumalatedtokens){
	 	 	 if(frecuenciedTokens.contains(token))
	 	 	 	 continue;
	 	 	 frecuency = Collections.frequency(accumalatedtokens, token);
	 	 	 token.setfrecuency(frecuency);
	 	 	 frecuenciedTokens.add(token);
		 }
		 frecuenciedTokens.sort((o1, o2) -> Integer.compare(o2.getFrecuency(), o1.getFrecuency()));
	 	 return frecuenciedTokens;

	 }
	 public String getFrecuencyWordListAsString(){
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

	 public String getFrecuencyKanjiListAsString(){
		 StringBuilder stringBuilder = new StringBuilder();
		 List<JpCharacterToken> characters = this.getFrecuencyKanjiList();
		 Iterator<JpCharacterToken> it = characters.iterator();
		 int counter = 1;
		 while(it.hasNext()){
			JpCharacterToken tk = it.next();
			stringBuilder.append(counter+": ").append(tk.getCharacter()).append(",").append(tk.getFrecuency()).append("\n");
			counter++;
		 }
		 return stringBuilder.toString();
	 }

}
