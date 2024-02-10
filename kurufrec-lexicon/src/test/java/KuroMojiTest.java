import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier.WordFrecuencier.WordFrecuencier;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

public class KuroMojiTest {



    @Test
    public void testSpeechParts(){

        String input =  "金色の月に触れてみたいや 嫌, 金色の月に触れてみたいや 嫌, 金色";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).build();
        System.out.println("-------------------------EVENTS--------------------------------");
        WordFrecuencier frecuencier = new WordFrecuencier(analyzer);
        frecuencier.addListener((event, origin) -> System.out.println(event.toString() + " :: "+((WordFrecuencier)origin).getCurrent()));
        Map<Word, Integer> result = frecuencier.execute();
        System.out.println("-------------------------RESULTS--------------------------------");
        result.forEach((word, integer) -> System.out.println(word.getSurface() + " ::: " +integer+" ::: "+word.getPartofspeech()));

    }
    @Test
    public void shouldGetPartsSpeech(){
        TextAnalyzer<Word> anaylzer = KuroTextAnalyzerBuilder.builder("").build();
        Arrays.stream(anaylzer.getAllSpeechParts()).forEach(System.out::println);
    }



}
