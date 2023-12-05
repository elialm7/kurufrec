package TextEntities.Character;

public class CharacterBuilder {

    private String character;
    private int frecuency;
    public CharacterBuilder(){}

    public CharacterBuilder withCharacter(String character ){
        this.character = character;
        return this;
    }

    public CharacterBuilder withFrecuency(int frecuency){
        this.frecuency = frecuency;
        return this;
    }
    public Character build(){
        return new Character(character, frecuency);
    }
}
