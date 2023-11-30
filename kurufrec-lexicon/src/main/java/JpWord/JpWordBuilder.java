/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package LexiconEntities.JpWord;

import LexiconEntities.JpCharacter.JpCharacterToken;
import LexiconEntities.JpCharacter.JpCharacterTokenBuilder;
import com.atilika.kuromoji.ipadic.Token;
import com.moji4j.MojiConverter;
import com.moji4j.MojiDetector;

import java.util.ArrayList;
import java.util.List;

public class JpWordBuilder {

	 public static final String KURO_JP_NOUN_FILTER = "名詞";
	 public static final String KURO_JP_VERB_FILTER = "動詞";
	 public static final String KURO_JP_PARTICLE_FILTER = "助詞";
	 public static final String KURO_JP_ADJECTIVE_FILTER = "形容詞";

	 public static final String KURO_JP_ADVERB_FILTER = "副詞";
	 public static final String KURO_JP_AUXILIARY_VERB_FILTER = "助動詞";
	 public static final String KURO_JP_SYMBOL_FILTER = "記号";
	 public static final String KURO_JP_ADNOMINAL_ADJECTIVE_FILTER = "連体詞";
	 public static final String KURO_JP_INTERJECTION_FILTER = "感動詞";

	 public static final String KURO_JP_PREFIX_FILTER = "接頭詞";
	 public static final String KURO_JP_CONJUNCTION_FILTER = "接続詞";

	 public static final String ADJECTIVE_ENGLISH = "Adjective";
	 public static final String VERB_ENGLISH = "Verb";
	 public static final String NOUN_ENGLISH = "Noun";
	 public static final String PARTICLE_ENGLISH  = "Particle";

	 public static final String ADVERB_ENGLISH = "Adverb";
	 public static final String AUXILIARY_VERB_ENGLISH = "Auxiliary verb";
	 public static final String SYMBOL_ENGLISH = "Symbol";
	 public static final String ADNOMINAL_ADJECTIVE_ENGLISH = "Adnominal Adjective";
	 public static final String INTERJECTION_ENGLISH = "Interjection";

	 public static final String PREFIX_ENGLISH = "Prefix";
	 public static final String CONJUNCTION_ENGLISH = "Conjunction";

	 public static final int NOUN_WEIGH = 0;
	 public static final int VERB_WEIGH = 1;
	 public static final int ADJECTIVE_WEIGH = 2;
	 public static final int PARTICLE_WEIGH = 3;

	 public static final int ADVERB_WEIGH = 4;
	 public static final int AUXILIARY_VERB_WEIGH = 5;
	 public static final int SYMBOL_WEIGH = 6;
	 public static final int ADNOMINAL_ADJECTIVE_WEIGH = 7;
	 public static final int INTERJECTION_WEIGH = 8;

	 public static final int PREFIX_WEIGH = 9;
	 public static final int CONJUNCTION_WEIGH = 10;

	 public static final int NO_DEFINED_WEIGH = -1;

	 private static MojiDetector detector;
	 private static MojiConverter converter;

	 public static JpWord fromToken(Token tk){
	 	 detector = new MojiDetector();
	 	 converter = new MojiConverter();
	 	 JpWord word = new JpWord();
	 	 String speech_1 = tk.getPartOfSpeechLevel1();
	 	 String theword = tk.getSurface();
	 	 word.setType(getTypeInEnglishForKuro(speech_1));
	 	 word.setWeigh(getTypeWeigh(speech_1));
	 	 word.setWord(theword);
	 	 word.setReading(tk.getReading());
	 	 word.setPronunciation(tk.getPronunciation());
	 	 word.setRomaji(getRomaji(word.getReading()));
	 	 word.setCharacters(getCharacters(theword));
	 	 return word;
	 }

	 private static List<String> getCharacters(String word){
	 	 List<String> characters = new ArrayList<>();
	 	 for(int i = 0; i <  word.length(); i = word.offsetByCodePoints(i, 1)){
	 	 	 String character = new String(Character.toChars(word.codePointAt(i)));
	 	 	 characters.add(character);
		 }
		 return characters;
	 }

	 public static List<JpCharacterToken> getCharactersTokenfromWord(JpWord word){
	 	 List<String> characters = word.getCharacters();
	 	 List<JpCharacterToken> JpCharacterTokens = new ArrayList<>();
	 	 for(String character: characters){
	 	 	 JpCharacterTokenBuilder builder = new JpCharacterTokenBuilder();
	 	 	 builder.withCharacter(character).withFrecuency(0);
	 	 	 JpCharacterTokens.add(builder.build());
		 }
		 return JpCharacterTokens;
	 }


	 private static String getRomaji(String kana){
	 	 //implementation goes here
		  if(detector.hasKana(kana)){
		  	 return converter.convertKanaToRomaji(kana);
		  }
		  return "";
	 }

	 public static List<JpWord> fromTokens(List<Token> tokens){
	 	 List<JpWord> words = new ArrayList<>();
		  for(Token tok: tokens){
			   words.add(fromToken(tok));
		  }
		  return words;
	 }


	 private static String getTypeInEnglishForKuro(String str){
	 	 if(str.equalsIgnoreCase(KURO_JP_ADJECTIVE_FILTER)){
	 	 	 return ADJECTIVE_ENGLISH;
		 }else if (str.equalsIgnoreCase(KURO_JP_VERB_FILTER)){
	 	 	 return VERB_ENGLISH;
		 }else if (str.equalsIgnoreCase(KURO_JP_NOUN_FILTER)){
	 	 	 return NOUN_ENGLISH;
		 }else if(str.equalsIgnoreCase(KURO_JP_PARTICLE_FILTER)){
	 	 	 return PARTICLE_ENGLISH;
		 }else if(str.equalsIgnoreCase(KURO_JP_ADVERB_FILTER)){
	 	 	 return ADVERB_ENGLISH;
		 }else if (str.equalsIgnoreCase(KURO_JP_AUXILIARY_VERB_FILTER)){
	 	 	 return AUXILIARY_VERB_ENGLISH;
		 }else if (str.equalsIgnoreCase(KURO_JP_SYMBOL_FILTER)){
	 	 	 return SYMBOL_ENGLISH;
		 }else if(str.equalsIgnoreCase(KURO_JP_ADNOMINAL_ADJECTIVE_FILTER)){
	 	 	 return ADNOMINAL_ADJECTIVE_ENGLISH;
		 }else if (str.equalsIgnoreCase(KURO_JP_INTERJECTION_FILTER)){
	 	 	 return INTERJECTION_ENGLISH;
		 }else if(str.equalsIgnoreCase(KURO_JP_PREFIX_FILTER)){
	 	 	 return PREFIX_ENGLISH;
		 }else if(str.equalsIgnoreCase(KURO_JP_CONJUNCTION_FILTER)){
	 	 	 return CONJUNCTION_ENGLISH;
		 }
		 //In case it doesnt fit, it will just return the japanese version.
		 return str;
	 }

	 private static int getTypeWeigh(String type){
	 	 int weigh = NO_DEFINED_WEIGH;
	 	 if(type.equalsIgnoreCase(KURO_JP_PARTICLE_FILTER)){
	 	 	 weigh =  PARTICLE_WEIGH;
		 }else if(type.equalsIgnoreCase(KURO_JP_NOUN_FILTER)){
	 	 	 weigh =  NOUN_WEIGH;
		 }else if (type.equalsIgnoreCase(KURO_JP_VERB_FILTER)){
	 	 	 weigh = VERB_WEIGH;
		 }else if(type.equalsIgnoreCase(KURO_JP_ADJECTIVE_FILTER)){
	 	 	 weigh = ADJECTIVE_WEIGH;
		 }else if (type.equalsIgnoreCase(KURO_JP_ADVERB_FILTER)){
	 	 	 weigh = ADVERB_WEIGH;
		 }else if(type.equalsIgnoreCase(KURO_JP_AUXILIARY_VERB_FILTER)){
	 	 	 weigh = AUXILIARY_VERB_WEIGH;
		 }else if(type.equalsIgnoreCase(KURO_JP_SYMBOL_FILTER)){
	 	 	 weigh = SYMBOL_WEIGH;
		 }else if(type.equalsIgnoreCase(KURO_JP_ADNOMINAL_ADJECTIVE_FILTER)){
	 	 	 weigh = ADNOMINAL_ADJECTIVE_WEIGH;
		 }else if (type.equalsIgnoreCase(KURO_JP_INTERJECTION_FILTER)){
	 	 	 weigh = INTERJECTION_WEIGH;
		 }else if(type.equalsIgnoreCase(KURO_JP_PREFIX_FILTER)){
	 	 	 weigh = PREFIX_WEIGH;
		 }else if(type.equalsIgnoreCase(KURO_JP_CONJUNCTION_FILTER)){
	 	 	 weigh = CONJUNCTION_WEIGH;
		 }
		 return weigh;
	 }


}
