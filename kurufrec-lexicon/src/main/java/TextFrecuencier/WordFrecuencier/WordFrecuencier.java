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

    private void addWordtoMap(List<Word> wordListreference){
         for(Word currentWord: wordListreference){
             if(frecuencies.containsKey(currentWord)){
                 int frecuency = frecuencies.get(currentWord);
                 frecuencies.put(currentWord, frecuency+1);
                 continue;
             }
             frecuencies.put(currentWord, 1);
         }
    }

    private void createResultList(List<Word> resultWordListReference){
         for(Word currentWord: frecuencies.keySet()){
             int wordFrecuency = frecuencies.get(currentWord);
             currentWord.setFrecuency(wordFrecuency);
             resultWordListReference.add(currentWord);
         }
    }

    @Override
    public List<Word> doFrecuency() {
         if(analyzer == null) throw new IllegalArgumentException("The TextAnalyzer is not provided. Provide a TextAnalyzer instance. ");
        List<Word> words = analyzer.analyze();
        addWordtoMap(words);
        List<Word> wordsresults = new ArrayList<>();
        createResultList(wordsresults);
        return wordsresults;
    }
}
