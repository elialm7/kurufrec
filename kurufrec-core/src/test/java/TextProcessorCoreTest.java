import Core.KuroIpadicTextFrecuencier;
import Core.KuroIpadicTextTokenizer;
import Core.KuroIpadicTokenizerConfiguration;
import Services.TextProcessorCoreService;
import org.junit.jupiter.api.Test;

public class TextProcessorCoreTest {


    String textExample = "金色の月に触れてみたいや 嫌, 金色の月に触れてみたいや 嫌, 金色, lol";

    @Test
    public void test(){
        TextProcessorCoreService service = new TextProcessorCoreService(new KuroIpadicTextFrecuencier(), new KuroIpadicTextTokenizer(KuroIpadicTokenizerConfiguration.Default()));
        service.loadInput(textExample);
        service.performFrecuency().forEach(System.out::println);
    }


}
