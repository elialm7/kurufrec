package TextEntities.Word;

import java.util.Objects;

public class Word  {
    private String surface;
    private String partofspeech;
    private String baseform;
    private String reading;
    private String pronunciation;
    private int weight;

    Word(String surface, String partofspeech, String baseform, String reading, String pronunciation, int weigth){
         this.surface = surface;
         this.partofspeech = partofspeech;
         this.baseform = baseform;
         this.reading = reading;
         this.pronunciation = pronunciation;
         this.weight = weigth;
    }

    public String getSurface() {
        return surface;
    }

    public String getPartofspeech() {
        return partofspeech;
    }

    public String getBaseform() {
        return baseform;
    }

    public String getReading() {
        return reading;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(surface, word.surface);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surface);
    }
}
