package TextEntities.Character;

import Prototype.Prototype;

public class Character implements Prototype<Character> {

    private String character;
    private int frecuency;

     Character(String character, int fecuency) {
        this.character = character;
        this.frecuency = fecuency;
    }
     Character(Character chara){
        this.character= chara.getCharacter();
        this.frecuency = chara.getFrecuency();
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
    }

    @Override
    public Character clone() {
        return new Character(this);
    }
}
