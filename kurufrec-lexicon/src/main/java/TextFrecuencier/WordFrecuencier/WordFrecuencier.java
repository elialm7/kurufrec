package TextFrecuencier.WordFrecuencier;

import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrecuencier implements Frecuencier<Word> {

    private TextAnalyzer<Word> analyzer;
    private Map<Word, Integer> frecuencies;

     WordFrecuencier(TextAnalyzer<Word> Analyzer){
        this.analyzer = Analyzer;
        this.frecuencies = new HashMap<>();
    }

    @Override
    public List<Word> doFrecuency() {
         if(analyzer == null) throw new IllegalArgumentException("The TextAnalyzer is not provided. Provide a TextAnalyzer instance. ");

        List<Word> words = analyzer.analyze();
        for(Word eword: words){
            if(frecuencies.containsKey(eword)){
                int frecuency = frecuencies.get(eword);
                frecuencies.put(eword, frecuency+1);
                continue;
            }
            frecuencies.put(eword, 1);
        }
        List<Word> wordsresults = new ArrayList<>();
        for(Word w: frecuencies.keySet()){
            int wordFrecuency = frecuencies.get(w);
            w.setFrecuency(wordFrecuency);
            wordsresults.add(w);
        }
        return wordsresults;
    }
}
