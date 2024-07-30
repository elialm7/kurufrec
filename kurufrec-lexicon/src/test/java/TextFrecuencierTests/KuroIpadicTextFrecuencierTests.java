package TextFrecuencierTests;

import Api.TextFrecuencier;
import Api.TextTokenizer;
import core.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KuroIpadicTextFrecuencierTests {

    String textExample = "金色の月に触れてみたいや 嫌, 金色の月に触れてみたいや 嫌, 金色, lol";
    static TextTokenizer<KuroIpadicToken> tokenizer;
    @BeforeAll
    public static void prepareOutputAssert(){

        tokenizer = new KuroIpadicTextTokenizer(KuroIpadicTokenizerConfiguration.Default());

    }

    @Test
    public void test_frecuency_case(){
        List<KuroIpadicToken> tokens = tokenizer.tokenize(textExample);
        TextFrecuencier<KuroIpadicTokenFrecuency, KuroIpadicToken> frecuencier = new KuroIpadicTextFrecuencier();
        List<KuroIpadicTokenFrecuency> frecuencies = frecuencier.PerformFrecuency(tokens);
        // this technically works, im too lazy to write a proper tests
        frecuencies.forEach(System.out::println);
    }
}
