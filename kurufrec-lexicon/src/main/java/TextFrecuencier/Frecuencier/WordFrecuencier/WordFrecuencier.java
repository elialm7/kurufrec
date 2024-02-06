package TextFrecuencier.Frecuencier.WordFrecuencier;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier.Frecuencier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

public class WordFrecuencier extends Frecuencier<Map<Word, Integer>> {
    private static Logger log = LogManager.getLogger(WordFrecuencier.class);
    private TextAnalyzer<Word> analyzer;
    private Map<Word, Integer> frecuenciesmap;
     public WordFrecuencier(TextAnalyzer<Word> Analyzer){
        this.analyzer = Analyzer;
        this.frecuenciesmap = new HashMap<>();
    }
    @Override
    public Map<Word, Integer> execute() {
         emitEvent(Event.PREPARING, this);
         if(Objects.isNull(analyzer)) {
             log.error("The analyzer was not provided.");
             throw new NullPointerException("Analyzer wasn't provided.");
         }
         List<Word> words = analyzer.analyze();
         setMin(0);
         setMax(words.size());
         emitEvent(Event.READY, this);
         emitEvent(Event.EXECUTING, this);
         for(int counter = 0; counter < words.size(); counter++){
             setCurrent(counter);
             Word currentWord = words.get(counter);
             if(frecuenciesmap.containsKey(currentWord)){
                 int frecuency = frecuenciesmap.get(currentWord);
                 frecuenciesmap.put(currentWord, frecuency+1);
                 continue;
             }
             frecuenciesmap.put(currentWord, 1);
        }
         emitEvent(Event.FINISHED, this);
        return frecuenciesmap;
    }

}
