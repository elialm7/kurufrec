package TextFrecuencier.WordFrecuencier;

import KanaConversion.KanaConversion;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;

public class WordFrecuencierBuilder {
    private TextAnalyzer<Word> analyzer;
    private  KanaConversion converter;

    private WordFrecuencierBuilder(){}

    public static WordFrecuencierBuilder builder(){
        return new WordFrecuencierBuilder();
    }

    public WordFrecuencierBuilder withAnalyzer(TextAnalyzer<Word> analyzer){

        this.analyzer = analyzer;
        return this;
    }

    public WordFrecuencier build(){
        return new WordFrecuencier(analyzer);
    }


}
