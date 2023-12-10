package TextAnalyzer.Imp;

import KanaConversion.KanaConversion;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import Utils.kuromoji.KuroMojiFunctionsUtils;
import com.atilika.kuromoji.TokenizerBase;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.util.List;

public class KuroTextAnalyzer implements TextAnalyzer<Word> {

    private String inputText;
    private KanaConversion converter;

    private boolean searchmode = false;
    private boolean extendedmode = false;

     KuroTextAnalyzer(String inputText, KanaConversion converter){
        this.inputText = inputText;
        this.converter = converter;
    }


    private Tokenizer defaultTokenizer(){
         return new Tokenizer();
    }

    @Override
    public List<Word> analyze() {
         if(converter == null) throw new IllegalArgumentException("The Kanaconverter for the readings is not provided. Provide a KanaConversion instance.");

        Tokenizer tokenizer = defaultTokenizer();
        return KuroMojiFunctionsUtils.NewFunctionUtils(converter).fromTokens(tokenizer.tokenize(inputText));
    }
}
