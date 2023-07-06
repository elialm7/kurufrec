
/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package Model.Lexicon.JapaneseLexicon.JpWord;


import java.util.Objects;

public class JpWord{
	private String word;
	private String Reading;
	private String Pronunciation;
	private String type;
	private String romaji;
	private int weigh;
	private int frecuency;
	private String index;

	 public String getWord() {
		  return word;
	 }

	 public void setWord(String word) {
		  this.word = word;
	 }

	 public String getType() {
		  return type;
	 }

	 public void setType(String type) {
		  this.type = type;
	 }

	 public int Weigh() {
		  return weigh;
	 }

	 public void setWeigh(int weigh) {
		  this.weigh = weigh;
	 }

	 public int getFrecuency() {
		  return frecuency;
	 }

	 public void setFrecuency(int frecuency) {
		  this.frecuency = frecuency;
	 }

	 public String getIndex() {
		  return index;
	 }

	 public void setIndex(String index) {
		  this.index = index;
	 }

	 public String getReading() {
		  return Reading;
	 }

	 public void setReading(String reading) {
		  Reading = reading;
	 }

	 public int getWeigh() {
		  return weigh;
	 }

	 public String getPronunciation() {
		  return Pronunciation;
	 }

	 public void setPronunciation(String pronunciation) {
		  Pronunciation = pronunciation;
	 }


	 public String getRomaji() {
		  return romaji;
	 }

	 public void setRomaji(String romaji) {
		  this.romaji = romaji;
	 }

	 @Override
	 public boolean equals(Object o) {
		  if (this == o) return true;
		  if (o == null || getClass() != o.getClass()) return false;
		  JpWord jpWord = (JpWord) o;
		  return Objects.equals(getWord(), jpWord.getWord());
	 }

	 @Override
	 public int hashCode() {
		  return Objects.hash(getWord());
	 }

	 public boolean is(String type){
	 	 return this.type.equalsIgnoreCase(type);
	 }

	 @Override
	 public String toString() {
		  return word + "," + Reading +"," + Pronunciation + "," +type + ","+ weigh +
				  "," + frecuency+","+romaji;
	 }
}
