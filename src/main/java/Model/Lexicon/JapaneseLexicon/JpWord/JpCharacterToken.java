package Model.Lexicon.JapaneseLexicon.JpWord;

public class JpCharacterToken {

	 private String Character;
	 private int frecuency;

	 public void setfrecuency(int frecuency){
	 	 this.frecuency = frecuency;
	 }
	 public int getFrecuency(){
	 	 return this.frecuency;
	 }
	 public void setCharacter(String character){
	 	 this.Character = character;
	 }

	 public String getCharacter(){
	 	 return this.Character;
	 }


}
