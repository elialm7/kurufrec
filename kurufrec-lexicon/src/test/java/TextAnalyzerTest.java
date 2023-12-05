import TextAnalyzer.Imp.KuroTextAnalyzerFactory;
import TextAnalyzer.TextAnalyzer;
import TextAnalyzer.TextAnalyzerFactory;
import com.atilika.kuromoji.ipadic.Token;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextAnalyzerTest {


    @Test
    public void testingtokenizer(){
        //obs: this is not the correct way to write tests, but it works for what i need to check.
        TextAnalyzerFactory factory = new KuroTextAnalyzerFactory();
        TextAnalyzer<Token> analyzer = factory.createAnalyzer("感情的に毎日を");
        List<Token> results = analyzer.analyze();
        results.forEach(e -> System.out.println(e.getReading()));
    }

}
