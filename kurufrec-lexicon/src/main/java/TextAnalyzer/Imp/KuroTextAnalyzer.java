package TextAnalyzer.Imp;
import KanaConversion.Imp.KanaConversionKuru;
import KanaConversion.KanaConversion;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import Utils.kuromoji.KuroMojiFunctionsUtils;
import com.atilika.kuromoji.TokenizerBase;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.util.List;


public class KuroTextAnalyzer implements TextAnalyzer<Word> {

    public enum TextAnalyzerMode{
        SEARCH, EXTENDED, NORMAL
    }
    private String inputText;
    private KanaConversion converter;
    private TextAnalyzerMode mode;

    private boolean allowNakaguroSplit = false;

    KuroTextAnalyzer(String inputText, KanaConversion converter, TextAnalyzerMode mode, boolean allowNakaguroSplit){
         this.inputText = inputText;
         this.converter = converter;
         this.mode = mode;
         this.allowNakaguroSplit = allowNakaguroSplit;
    }

    private Tokenizer defaultTokenizer(){
         return new Tokenizer();
    }


    private Tokenizer tokenizerWithMode(){
         switch (mode){
             case NORMAL -> new Tokenizer.Builder().mode(TokenizerBase.Mode.NORMAL)
                                    .isSplitOnNakaguro(allowNakaguroSplit)
                                    .build();
             case SEARCH -> new Tokenizer.Builder().mode(TokenizerBase.Mode.SEARCH)
                                                    .isSplitOnNakaguro(allowNakaguroSplit)
                                                    .build();
             case EXTENDED -> new Tokenizer.Builder().mode(TokenizerBase.Mode.EXTENDED)
                                                     .isSplitOnNakaguro(allowNakaguroSplit)
                                                     .build();
         }
         //unreachable...
         return defaultTokenizer();
    }

    private Tokenizer getTokenizer(){
         if(this.mode == null) {
             return defaultTokenizer();
         }else {
             return tokenizerWithMode();
         }
    }

    private KuroMojiFunctionsUtils getUtils(){
        if(this.converter == null){
            return KuroMojiFunctionsUtils.NewFunctionUtils();
        }else {
            return KuroMojiFunctionsUtils.NewFunctionUtils(converter);
        }
    }

    @Override
    public List<Word> analyze() {
        Tokenizer tokenizer = getTokenizer();
        return getUtils().fromTokens(tokenizer.tokenize(inputText));
    }
}
