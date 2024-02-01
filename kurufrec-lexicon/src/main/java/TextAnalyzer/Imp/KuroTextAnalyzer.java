package TextAnalyzer.Imp;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextEntities.Word.WordBuilder;
import Utils.kuromoji.KuroSpeechParts;
import com.atilika.kuromoji.TokenizerBase;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.util.ArrayList;
import java.util.List;


public class KuroTextAnalyzer implements TextAnalyzer<Word> {

    public enum TextAnalyzerMode{
        SEARCH, EXTENDED, NORMAL
    }
    private String inputText;
    private TextAnalyzerMode mode;

    private boolean allowNakaguroSplit = false;

    KuroTextAnalyzer(String inputText,  TextAnalyzerMode mode, boolean allowNakaguroSplit){
         this.inputText = inputText;
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
         return defaultTokenizer();
    }

    private Tokenizer getTokenizer(){
         if(this.mode == null) {
             return defaultTokenizer();
         }else {
             return tokenizerWithMode();
         }
    }

    private KuroSpeechParts parseSpeech(String speech){
            if(speech.equalsIgnoreCase(KuroSpeechParts.NOUN.getJpWord())){
                return KuroSpeechParts.NOUN;
            }else if(speech.equalsIgnoreCase(KuroSpeechParts.ADJECTIVE.getJpWord())){
                return KuroSpeechParts.ADJECTIVE;
            }else if(speech.equalsIgnoreCase(KuroSpeechParts.VERB.getJpWord())){
                return KuroSpeechParts.VERB;
            }else if(speech.equalsIgnoreCase(KuroSpeechParts.ADVERB.getJpWord())){
                return KuroSpeechParts.ADVERB;
            }else if(speech.equalsIgnoreCase(KuroSpeechParts.PARTICLE.getJpWord())){
                return KuroSpeechParts.PARTICLE;
            }else {
                return KuroSpeechParts.UNSUPPORTED;
            }
    }


    private Word wordFromtoken(Token tk){
        WordBuilder builder = new WordBuilder();
        String surface = tk.getSurface();
        KuroSpeechParts speechpart = parseSpeech(tk.getPartOfSpeechLevel1());
        String baseform = tk.getBaseForm();
        String reading = tk.getReading();
        String pronunciation = tk.getPronunciation();
        builder.surface(surface).partOfSpeech(speechpart).baseform(baseform).reading(reading).pronunciation(pronunciation);
        return builder.build();
    }

    private List<Word> getWordsFromTokens(List<Token> tokens){
        List<Word> words = new ArrayList<>();
        for (Token token : tokens) {
            words.add(wordFromtoken(token));
        }
        return words;

    }

    @Override
    public List<Word> analyze() {
        Tokenizer tokenizer = getTokenizer();
        return getWordsFromTokens(tokenizer.tokenize(inputText));
    }
}
