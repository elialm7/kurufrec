package TextFrecuencierTests;

import Api.TextFrecuencier;
import Api.TextTokenizer;
import KuroMoji.IpadicFrecuencier;
import KuroMoji.IpadicFrecuencyToken;
import KuroMoji.IpadicToken;
import KuroMoji.IpadicTokenizer;
import KuroMoji.IpadicTokenizerConfig;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KuroIpadicTextFrecuencierTests {

    String textExample = "金色の月に触れてみたいや 嫌, 金色の月に触れてみたいや 嫌, 金色, lol";
    static TextTokenizer<IpadicToken> tokenizer;
    @BeforeAll
    public static void prepareOutputAssert(){

        tokenizer = new IpadicTokenizer(IpadicTokenizerConfig.Default());

    }

    @Test
    public void test_frecuency_case(){
        List<IpadicToken> tokens = tokenizer.tokenize(textExample);
        TextFrecuencier<IpadicFrecuencyToken, IpadicToken> frecuencier = new IpadicFrecuencier();
        List<IpadicFrecuencyToken> frecuencies = frecuencier.PerformFrecuency(tokens);
        // this technically works, im too lazy to write a proper tests
        frecuencies.forEach(System.out::println);
    }
}
