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
         int maxsize = wordListreference.size();
         int counter = 1;
         updateProgress(counter, maxsize);
         for(Word currentWord: wordListreference){
             updateProgress(counter, maxsize);
             counter++;
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
        setChangedState(State.PREPARING);
        updateMessage("Checking analyzer");
         if(analyzer == null) {
             setChangedState(State.FAILED);
             updateMessage("The analyzer is not provided...");
             throw new IllegalArgumentException("The TextAnalyzer is not provided. Provide a TextAnalyzer instance. ");
         }
         setChangedState(State.READY);
         updateMessage("Analyzer checked!");
         setChangedState(State.EXECUTING);
         updateMessage("Starting Analysis of the Content");
        List<Word> words = analyzer.analyze();
        updateMessage("Frecuency Operation has started... ");
        mapfrecuency(words);
        List<Word> wordsresults = new ArrayList<>();
        setChangedState(State.FINISHING);
        updateMessage("Preparing results... ");
        createResultList(wordsresults);
        setChangedState(State.FINISHED);
        updateMessage("Results are finished.");
        return wordsresults;
    }
}
