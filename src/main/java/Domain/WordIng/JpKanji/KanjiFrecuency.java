package Domain.WordIng.JpKanji;

import java.util.Objects;

public class KanjiFrecuency {

	 private String kanji;
	 private int frecuency;

	 public KanjiFrecuency(){

	 }

	 public KanjiFrecuency(String kanji, int frecuency) {
		  this.kanji = kanji;
		  this.frecuency = frecuency;
	 }

	 public String getKanji() {
		  return kanji;
	 }

	 public void setKanji(String kanji) {
		  this.kanji = kanji;
	 }

	 public int getFrecuency() {
		  return frecuency;
	 }

	 public void setFrecuency(int frecuency) {
		  this.frecuency = frecuency;
	 }

	 @Override
	 public boolean equals(Object o) {
		  if (this == o) return true;
		  if (o == null || getClass() != o.getClass()) return false;
		  KanjiFrecuency that = (KanjiFrecuency) o;
		  return Objects.equals(getKanji(), that.getKanji());
	 }

	 @Override
	 public int hashCode() {

		  return Objects.hash(getKanji());
	 }

	 @Override
	 public String toString() {
		  return this.kanji + " = "+this.frecuency;
	 }
}
