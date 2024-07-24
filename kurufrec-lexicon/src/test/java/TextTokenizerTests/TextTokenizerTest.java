package TextTokenizerTests;

import Api.TextTokenizer;
import core.KuroIpadicToken;
import core.KuroIpadicTokenizer;
import core.KuroIpadicTokenizerConfiguration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TextTokenizerTest {

    String textExample = "金色の月に触れてみたいや 嫌, 金色の月に触れてみたいや 嫌, 金色, lol";
    @Test
    public void should_Instantiate_thetokenizer_with_InitialConfiguration(){
        //this is a silly test btw.
        TextTokenizer<KuroIpadicToken> tokenizer = new KuroIpadicTokenizer(KuroIpadicTokenizerConfiguration.Default());
        assertNotNull(tokenizer, "Could not instantiate the tokenizer. we got a null one");
    }
    @Test
    public void should_return_an_empty_list_if_string_empty(){
        TextTokenizer<KuroIpadicToken> tokenizer = new KuroIpadicTokenizer(KuroIpadicTokenizerConfiguration.Default());
        List<KuroIpadicToken> tokens = tokenizer.tokenize("");
        assertNotNull(tokens, "the tokenize method must not return a null list");
        assertEquals(0, tokens.size(), "Must return zero if and empty string is passed");
    }
    @Test
    public void should_return_an_not_empty_list_if_string_not_empty(){
        TextTokenizer<KuroIpadicToken> tokenizer = new KuroIpadicTokenizer(KuroIpadicTokenizerConfiguration.Default());
        List<KuroIpadicToken> tokens = tokenizer.tokenize(textExample);
        assertFalse(tokens.isEmpty(), "it must return a list which is not empty");
    }

    @Test
    public void should_tokenize_into_ipadic_tokens(){
        // todo: write the test for this

    }


}
