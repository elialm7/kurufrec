/*
 * MIT License
 *
 * Copyright (c) 2022 Rodolfo Elias Ojeda Almada
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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
