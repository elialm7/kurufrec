package TextFrecuencier.FrecuencyStrategy.WordFrecuencier;

import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;

@Deprecated
public class WordFrecuencierBuilder {
    private TextAnalyzer<Word> analyzer;
    private WordFrecuencierBuilder(){}

    public static WordFrecuencierBuilder builder(){
        return new WordFrecuencierBuilder();
    }

    public WordFrecuencierBuilder withAnalyzer(TextAnalyzer<Word> analyzer){

        this.analyzer = analyzer;
        return this;
    }

    public WordFrecuencyStrategy build(){
        return new WordFrecuencyStrategy(analyzer);
    }


}
