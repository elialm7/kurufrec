import TextAnalyzer.Imp.KuroTextAnalyzer;
import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier.Frecuencier;
import TextFrecuencier.FrecuencyStrategy.FrecuencyStrategy;
import TextFrecuencier.FrecuencyStrategy.WordFrecuencier.WordFrecuencyStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextFrecuencierTest {


    @Test
    public void shouldreturnAfrecuencyListregardlessofthemode(){
        String input =  "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).build();
        FrecuencyStrategy<Word> strategy = new WordFrecuencyStrategy(analyzer);
        Frecuencier<Word> frecuencier = new Frecuencier<>();
        frecuencier.setStrategy(strategy);
        List<Word> frecuency = frecuencier.doFrecuency();
        Assertions.assertFalse(frecuency.isEmpty());
    }


}
