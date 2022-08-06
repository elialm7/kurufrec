/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package model.Lexicon.JapaneseLexicon.JpDecoder;

import com.atilika.kuromoji.ipadic.Token;
import model.Lexicon.JapaneseLexicon.JpWord.JpWord;
import model.Lexicon.JapaneseLexicon.JpWord.JpWordBuilder;

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