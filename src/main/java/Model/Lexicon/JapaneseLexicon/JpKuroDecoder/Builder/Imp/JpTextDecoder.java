/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Builder.Imp;

import com.atilika.kuromoji.ipadic.Token;
import Model.Lexicon.JapaneseLexicon.JpKuroDecoder.KuroDecoder;
import Model.Lexicon.JapaneseLexicon.JpWord.JpWord;
import Model.Lexicon.JapaneseLexicon.JpWord.JpWordBuilder;

import java.util.List;

public class JpTextDecoder extends KuroDecoder<String, List<JpWord>> {
	 private List<Token> tokens;
	 public void set(String InData){
	 		 tokens = getTokenized(InData);
	 }

	 public List<JpWord> get(){
	 	 return JpWordBuilder.fromTokens(tokens);
	 }
}