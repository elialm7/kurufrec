
/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package core.model.JpWording.tok;

import com.atilika.kuromoji.ipadic.Token;

import java.util.Objects;

public class JpToken  extends FrecuencyWordBase{
	private Token token;
	private String word;
	private int weigh;

	public JpToken(){

	}

	 public int getWeigh() {
		  return weigh;
	 }

	 public void setWeigh(int weigh) {
		  this.weigh = weigh;
	 }

	 public JpToken(Token tok){
		 this.token = tok;
		 this.word = tok.getSurface();

	}

	 public Token getToken() {
		  return token;
	 }

	 public void setToken(Token token) {
		  this.token = token;
	 }


	 public String getWord() {
		  return word;
	 }

	 public void setdefaultform(){
		this.word =  this.getToken().getBaseForm();
	 }

	 @Override
	 public boolean equals(Object o) {
		  if (this == o) return true;
		  if (o == null || getClass() != o.getClass()) return false;
		  JpToken jpToken = (JpToken) o;
		  return Objects.equals(getWord(), jpToken.getWord());
	 }

	 @Override
	 public int hashCode() {

		  return Objects.hash(getToken(), getFrecuency(), getWord());
	 }
}
