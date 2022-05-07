
/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package core.model.JpWording.tok;

import java.util.Objects;

public class KanjiFrecuency extends FrecuencyWordBase{

	 private String kanji;

	 public KanjiFrecuency(){

	 }

	 public KanjiFrecuency(String kanji, int frecuency) {
		  this.kanji = kanji;
		  super.setFrecuency(frecuency);
	 }

	 public String getKanji() {
		  return kanji;
	 }

	 public void setKanji(String kanji) {
		  this.kanji = kanji;
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
		  return this.kanji + " = "+super.getFrecuency();
	 }
}
