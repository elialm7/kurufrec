package TextAnalyzer.Imp;

import TextAnalyzer.TextAnalyzer;
import TextAnalyzer.TextAnalyzerFactory;

public class KuroTextAnalyzerFactory implements TextAnalyzerFactory {

    @Override
    public <Token> TextAnalyzer createAnalyzer(String input) {
        return new KuroTextAnalyzer(input);
    }
}
