package TextEntities.Word;

public class WordBuilder {

    private String content;
    private String reading;
    private String pronunciation;
    private String type;
    private int weight;
    private String romaji;
    private int frecuency;

    public WordBuilder withContent(String content){
        this.content = content;
        return this;
    }

    public WordBuilder withReading(String reading){
        this.reading = reading;
        return this;
    }

    public WordBuilder withPronunciation(String pronunciation){
        this.pronunciation = pronunciation;
        return this;
    }
    public WordBuilder withType(String type){
        this.type = type;
        return this;
    }

    public WordBuilder withWeight(int weight){
        this.weight = weight;
        return this;
    }
    public WordBuilder withFrecuency(int frecuency){
        this.frecuency = frecuency;
        return this;
    }

    public WordBuilder withRomaji(String romaji){
        this.romaji = romaji;
        return this;
    }
    public Word build(){
        return new Word(content, reading,pronunciation, type,romaji, weight, frecuency);
    }

}
