package KuromojiUsageTest;

import com.atilika.kuromoji.TokenizerBase;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class IpadicKuromojiUsageTest {

    String textExample = "金色の月に触れてみたいや 嫌, 金色の月に触れてみたいや 嫌, 金色, lol";
    static Tokenizer tokenizer;
    @BeforeAll
    public static void PrepareTokenizer(){
      tokenizer = new Tokenizer.Builder().build();
    }
    @Test
    public void shouldTokenize(){
        List<Token> tokens = tokenizer.tokenize(textExample);
        tokens.forEach(tk -> System.out.println(tk.toString()));
    }
    @Test
    public void getAllFeaturesFromFirstToken(){
        Token firsttoken = tokenizer.tokenize(textExample).get(0);
        Arrays.stream(firsttoken.getAllFeaturesArray()).forEach(System.out::println);
    }

    @Test
    public void getAllFeaturesFromAll(){
        List<Token> tokens = tokenizer.tokenize(textExample);
        tokens.forEach(tk -> System.out.println(tk.getAllFeatures()));
    }
}
