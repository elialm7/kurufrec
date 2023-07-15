/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpKuroDecoder.Factory.Imp;

import Model.Entities.LexiconEntities.JpWord.JpWord;
import Model.Entities.LexiconEntities.JpWord.JpWordBuilder;
import Model.Lexicon.Decoder.KuruDecoder;
import com.atilika.kuromoji.ipadic.Token;

import java.util.List;

public class JpTextDecoder extends KuruDecoder<String, List<JpWord>> {
	 private List<Token> tokens;
	 public void set(String InData){
	 		 tokens = getTokenized(InData);
	 }

	 public List<JpWord> get(){
	 	 return JpWordBuilder.fromTokens(tokens);
	 }
}