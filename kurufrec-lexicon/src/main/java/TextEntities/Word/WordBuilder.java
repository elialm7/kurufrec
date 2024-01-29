package TextEntities.Word;

import Utils.kuromoji.KuroSpeechParts;

public class WordBuilder {


    private String surfaceWord;
    private String partspeechWord;
    private String baseformWord;
    private String readingWord;
    private String pronunciationWord;
    private int Wordweight;


    public WordBuilder surface(String word){
        this.surfaceWord = word;
        return this;
    }

    public WordBuilder partOfSpeech(KuroSpeechParts partofspeech){
        this.Wordweight = partofspeech.getWeight();
        this.partspeechWord = partofspeech.toString();
        return this;
    }

    public WordBuilder baseform(String baseform){
        this.baseformWord = baseform;
        return this;
    }

    public WordBuilder reading(String reading){
        this.readingWord = reading;
        return this;
    }

    public WordBuilder pronunciation(String pronunciation){
        this.pronunciationWord = pronunciation;
        return this;
    }

    public Word build(){
       return new Word(surfaceWord, partspeechWord, baseformWord, readingWord, pronunciationWord, Wordweight);
    }


}
