package TextFrecuencier.FrecuencyStrategy.WordFrecuencier;

import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.FrecuencyStrategy.FrecuencyStrategy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WordFrecuencyStrategy extends FrecuencyStrategy<Word> {

    private TextAnalyzer<Word> analyzer;
    private Map<Word, Integer> frecuencies;

     public WordFrecuencyStrategy(TextAnalyzer<Word> Analyzer){
        this.analyzer = Analyzer;
        this.frecuencies = new HashMap<>();
    }

    private void mapfrecuency(List<Word> wordListreference){
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
    public List<Word> executeStrategy() {
         notifyObservers(State.PREPARING, "checking analyzer. ");
         if(analyzer == null) {
             notifyObservers(State.FAILED, "there was no analyzer defined. throwing exception.");
             throw new IllegalArgumentException("The TextAnalyzer is not provided. Provide a TextAnalyzer instance. ");
         }
        notifyObservers(State.READY, "Analyzer checked");
         notifyObservers( State.EXECUTING, "Starting analysis.");
        List<Word> words = analyzer.analyze();
        notifyObservers(State.EXECUTING, "Starting frecuency operation. ");
        mapfrecuency(words);
        List<Word> wordsresults = new ArrayList<>();
        notifyObservers( State.FINISHING, "Preparing Resulting list. ");
        createResultList(wordsresults);
        notifyObservers(State.FINISHED, "Frecuency finished. ");
        return wordsresults;
    }
}
