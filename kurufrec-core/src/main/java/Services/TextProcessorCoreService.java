package Services;

import Adapters.TextWordAdapter;
import Api.TextFrecuencier;
import Api.TextTokenizer;
import Core.KuroIpadicToken;
import Core.KuroIpadicTokenFrecuency;
import Domains.TextWord;

import java.util.ArrayList;
import java.util.List;

// ill take the road of least resistance and then ill refactor when it is needed.
public class TextProcessorCoreService {
    private TextFrecuencier<KuroIpadicTokenFrecuency, KuroIpadicToken> frecuencier;
    private TextTokenizer<KuroIpadicToken> tokenizer;
    private String text;


    public TextProcessorCoreService(TextFrecuencier<KuroIpadicTokenFrecuency, KuroIpadicToken> frecuencier, TextTokenizer<KuroIpadicToken> tokenizer){
        this.frecuencier = frecuencier;
        this.tokenizer = tokenizer;
    }

    public void loadInput(String text){
        this.text = text;
    }


    public List<TextWord>  performFrecuency(){
        return frecuencier.PerformFrecuency(tokenizer.tokenize(text)).parallelStream().map(TextWordAdapter::of).toList();
    }
}
