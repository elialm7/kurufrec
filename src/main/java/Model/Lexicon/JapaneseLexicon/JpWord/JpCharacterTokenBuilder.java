package Model.Lexicon.JapaneseLexicon.JpWord;

public class JpCharacterTokenBuilder {

	 private int frecuency;
	 private String character;

	 public JpCharacterTokenBuilder withCharacter(String character){
	 	 if(this.character.isEmpty()){
	 	 	 this.character = character;
		 }
		 return this;
	 }
	 public JpCharacterTokenBuilder withFrecuency(int frecuency){
	 	 this.frecuency = frecuency;
	 	 return this;
	 }

	 public JpCharacterToken build(){
	 	 JpCharacterToken token = new JpCharacterToken();
	 	 token.setCharacter(this.character);
	 	 token.setfrecuency(this.frecuency);
	 	 return token;
	 }


}
