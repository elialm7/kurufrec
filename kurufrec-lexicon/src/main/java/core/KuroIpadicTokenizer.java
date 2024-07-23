package core;

import Api.TextTokenizer;

import java.util.List;

public class KuroIpadicTokenizer implements TextTokenizer<KuroIpadicToken> {


    public KuroIpadicTokenizer(KuroIpadicTokenizerConfiguration kuroIpadicTokenizerConfiguration) {
    }

    @Override
    public List<KuroIpadicToken> analyze(String text) {
        return List.of();
    }
}
