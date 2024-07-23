package TextTokenizerTests;

import Api.TextTokenizer;
import core.KuroIpadicToken;
import core.KuroIpadicTokenizer;
import core.KuroIpadicTokenizerConfiguration;
import org.junit.jupiter.api.Test;
import core.TokenizerConfiguration;

import static org.junit.jupiter.api.Assertions.*;

public class TextTokenizerTest {

    @Test
    public void should_Instantiate_thetokenizer_with_InitialConfiguration(){
        TextTokenizer<KuroIpadicToken> tokenizer = new KuroIpadicTokenizer(KuroIpadicTokenizerConfiguration.Default());
        assertNotNull(tokenizer);
    }


}
