
/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package core.model.JpWording;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import core.model.JpWording.tok.JpToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class JpWordFrecuency {


	 //where the words from the source are added.
	 private List<String> jpStrings;
	 //where the tokens after the tokenization are added
	 private List<Token> tokens_kuro;
	 private Tokenizer tokenizer_kuro;
	 //just a wrapper for the Tokens already and for the frecuency list
	 private List<JpToken> jpTokens;

	 //this is where the tokenized word are added.
	 private List<String> tokenizedstring;

	 public JpWordFrecuency(){
	 	 this.jpStrings = new ArrayList<>();
	 	 this.tokens_kuro = new ArrayList<>();
	 	 this.tokenizer_kuro = new Tokenizer();
	 	 this.jpTokens = new ArrayList<>();
	 	 this.tokenizedstring = new ArrayList<>();
	 }


	 public void addJpString(String text){
	 	 this.jpStrings.add(text);
	 }

	 public void addJpString(List<String> texts){
	 	 if(!Objects.isNull(texts)) {
			  for (String e : texts) {
				   addJpString(e);
			  }
		 }else{
	 	 	 throw new NullPointerException("The text list must not be null");
		 }
	 }

	 public void tokenizeAddedWords(){
	 	 String appendedWords = buildStringFromList(this.jpStrings);
	 	 List<Token> newTokens = tokenizer_kuro.tokenize(appendedWords.trim());
	 	 this.tokens_kuro.addAll(newTokens);
	 	 this.tokenizedstring.addAll(this.jpStrings);
	 	 this.jpStrings.clear();
	 }

	 public List<Token> getTokens_kuro(){
	 	 return this.tokens_kuro;
	 }

	 public void doJpWordFrecuency(){
	 	 if(tokens_kuro.size() > 0){
			List<JpToken> newTokens = generateJpTokenList(this.tokens_kuro);
			int frecuency;
			for(JpToken jptoken: newTokens){
				 if(this.jpTokens.contains(jptoken))
				 	 continue;
				 frecuency = Collections.frequency(newTokens, jptoken);
				 jptoken.setFrecuency(frecuency);
				 this.jpTokens.add(jptoken);
			}
			this.jpTokens.sort(new DefaultFrecuencyComparator<>());
		 }else {
	 	 	 throw new UnsupportedOperationException("the frecuency cannot be made with 0 tokens");
		 }
	 }
	 public void doSorting(){
	 	 this.jpTokens.sort(new DefaultFrecuencyComparator<>());
	 }

	 private String buildStringFromList(List<String> strings){
	 	 StringBuilder newString = new StringBuilder();
	 	 for(String toappend: strings){
	 	 	 newString.append(toappend);
		 }
	 	 return newString.toString().replace(" ", "");
	 }

	 private List<JpToken> generateJpTokenList(List<Token> tokenList){
	 	 List<JpToken> newTokens = new ArrayList<>();
	 	 for(Token tok: tokenList){
	 	 	 newTokens.add(new JpToken(tok));
		 }
		 return newTokens;
	 }




	 public List<JpToken> setDefaultform(List<JpToken> list){

	 	 for(JpToken jp:list){
	 	 	 jp.setdefaultform();
		 }
		 return list;
	 }


	 public List<JpToken> getFrecuencyTokens(){
	 	 return this.jpTokens;
	 }

}
