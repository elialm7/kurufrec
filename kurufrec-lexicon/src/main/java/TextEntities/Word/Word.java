package TextEntities.Word;

import Prototype.Prototype;

public class Word implements Prototype<Word> {
    private String content;
    private String reading;
    private String pronunciation;
    private String type;
    private int weight;
    private int frecuency;
    private String romaji;

     Word(String content, String reading, String pronunciation, String type,String romaji,  int weight, int frecuency) {
        this.content = content;
        this.reading = reading;
        this.pronunciation = pronunciation;
        this.type = type;
        this.weight = weight;
        this.frecuency = frecuency;
        this.romaji = romaji;
    }

    public Word(Word word){
        this.content = word.getContent();
        this.reading = word.getReading();
        this.pronunciation =word.getPronunciation();
        this.type = word.getType();
        this.weight = word.getWeight();
        this.frecuency = word.getFrecuency();
        this.romaji = word.getRomaji();
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
    }


    @Override
    public Word clone() {
        return new Word(this);
    }
}
