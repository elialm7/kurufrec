package KuroMoji;

import Api.TextTokenizer;
import com.atilika.kuromoji.TokenizerBase;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.util.List;


public class IpadicTokenizer implements TextTokenizer<IpadicToken> {

    private IpadicTokenizerConfig configuration;
    public IpadicTokenizer(IpadicTokenizerConfig kuroIpadicTokenizerConfiguration) {
        this.configuration = kuroIpadicTokenizerConfiguration;
    }


    private Tokenizer buildTokenizerBasedOnMode(TokenizerBase.Mode mode){
        return new Tokenizer.Builder().mode(mode)
                .isSplitOnNakaguro(configuration.allowNakaguro())
                .kanjiPenalty(configuration.kanjiPenaltyLengthThreshold(), configuration.kanjiPenalty())
                .otherPenalty(configuration.otherPenaltyLengthThreshold(), configuration.otherPenalty())
                .build();
    }


    private Tokenizer createIpadicTokenizer(){
        var tokenizer = switch(configuration.mode()){
            case NORMAL -> buildTokenizerBasedOnMode(TokenizerBase.Mode.NORMAL);
            case SEARCH -> buildTokenizerBasedOnMode(TokenizerBase.Mode.SEARCH);
            case EXTENDED -> buildTokenizerBasedOnMode(TokenizerBase.Mode.EXTENDED);
        };
        return tokenizer;
    }
    private IpadicToken kuroIpadicTokenAdapterFn(Token tk){
        var surface = tk.getSurface();
        var speechpart = tk.getPartOfSpeechLevel1();
        var baseform = tk.getBaseForm();
        var conjugation_form = tk.getConjugationForm();
        var conjugation_type = tk.getConjugationType();
        var reading = tk.getReading();
        var pronunciation = tk.getPronunciation();

        return new IpadicToken(
                surface,
                speechpart,
                baseform,
                conjugation_form,
                conjugation_type,
                reading,
                pronunciation
        );
    }

    @Override
    public List<IpadicToken> tokenize(String text) {
        if(text.isEmpty() || text.isBlank()){
            return List.of();
        }
        Tokenizer tokenizer = createIpadicTokenizer();
        return tokenizer.tokenize(text).parallelStream().map(this::kuroIpadicTokenAdapterFn).toList();
    }
}
