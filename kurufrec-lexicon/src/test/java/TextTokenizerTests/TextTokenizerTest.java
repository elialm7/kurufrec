package TextTokenizerTests;

import Api.TextTokenizer;
import core.KuroIpadicToken;
import core.KuroIpadicTextTokenizer;
import core.KuroIpadicTokenizerConfiguration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TextTokenizerTest {

    String textExample = "金色の月に触れてみたいや 嫌, 金色の月に触れてみたいや 嫌, 金色, lol";
    @Test
    public void should_Instantiate_thetokenizer_with_InitialConfiguration(){
        //this is a silly test btw.
        TextTokenizer<KuroIpadicToken> tokenizer = new KuroIpadicTextTokenizer(KuroIpadicTokenizerConfiguration.Default());
        assertNotNull(tokenizer, "Could not instantiate the tokenizer. we got a null one");
    }
    @Test
    public void should_return_an_empty_list_if_string_empty(){
        TextTokenizer<KuroIpadicToken> tokenizer = new KuroIpadicTextTokenizer(KuroIpadicTokenizerConfiguration.Default());
        List<KuroIpadicToken> tokens = tokenizer.tokenize("");
        assertNotNull(tokens, "the tokenize method must not return a null list");
        assertEquals(0, tokens.size(), "Must return zero if and empty string is passed");
    }
    @Test
    public void should_return_an_not_empty_list_if_string_not_empty(){
        /*
        * i think that i don't need to write tests for these, since im just abstracting the imp of libraries
        * i pretend to use others libraries for tokenization later, so i 'need this abstraction' as simple as possible.
        * maybe ill learn how to make one myself, but for now i don't need to.
        * */
        TextTokenizer<KuroIpadicToken> tokenizer = new KuroIpadicTextTokenizer(KuroIpadicTokenizerConfiguration.Default());
        List<KuroIpadicToken> tokens = tokenizer.tokenize(textExample);
        assertFalse(tokens.isEmpty(), "it must return a list which is not empty");
    }


}
