package TextAnalyzer.Imp;

import TextAnalyzer.TextAnalyzer;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.util.List;

public class KuroTextAnalyzer implements TextAnalyzer<Token> {

    private String inputText;

    KuroTextAnalyzer(String inputText){
        this.inputText = inputText;
    }
    @Override
    public List<Token> analyze() {
        Tokenizer tokenizer = new Tokenizer();
        return tokenizer.tokenize(inputText);
    }
}
