import TextAnalyzer.Imp.KuroTextAnalyzer;
import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextAnalyzerTest {

    @Test
    public void shouldreturnWordsinMinimalBuild(){
        String input = "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).build();
        List<Word> words = analyzer.analyze();
        Assertions.assertFalse(words.isEmpty());
    }

    @Test
    public void shouldReturnWordsinNormalMode(){
        String input =  "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).withMode(KuroTextAnalyzer.TextAnalyzerMode.NORMAL).build();
        List<Word> words = analyzer.analyze();
        Assertions.assertFalse(words.isEmpty());
    }


    @Test
    public void shouldReturnWordsinSearchMode(){
        String input =  "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).withMode(KuroTextAnalyzer.TextAnalyzerMode.SEARCH).build();
        List<Word> words = analyzer.analyze();
        Assertions.assertFalse(words.isEmpty());
    }

    @Test
    public void shouldReturnWordsinExtendedMode(){
        String input =  "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).withMode(KuroTextAnalyzer.TextAnalyzerMode.EXTENDED).build();
        List<Word> words = analyzer.analyze();
        Assertions.assertFalse(words.isEmpty());
    }


    ///-------------------------------------------------------------------------------------------------------------------------------------------///
                // Same cases but now using nakaguro split.
    @Test
    public void shouldReturnWordswithNakaguroMinimalBuild(){
        String input =  "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).withNakaguroSplit(true).build();
        List<Word> words = analyzer.analyze();
        Assertions.assertFalse(words.isEmpty());
    }
    @Test
    public void shouldReturnWordsInNormalModewithNakaguroSplit(){
        String input =  "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).withMode(KuroTextAnalyzer.TextAnalyzerMode.NORMAL).withNakaguroSplit(true).build();
        List<Word> words = analyzer.analyze();
        Assertions.assertFalse(words.isEmpty());
    }
    @Test
    public void shouldReturnWordsInSearchModewithNakaguroSplit(){
        String input =  "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).withMode(KuroTextAnalyzer.TextAnalyzerMode.SEARCH).withNakaguroSplit(true).build();
        List<Word> words = analyzer.analyze();
        Assertions.assertFalse(words.isEmpty());
    }
    @Test
    public void shouldReturnWordsInExtenderModewithNakaguroSplit(){
        String input =  "金色の月に触れてみたいや 嫌";
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(input).withMode(KuroTextAnalyzer.TextAnalyzerMode.EXTENDED).withNakaguroSplit(true).build();
        List<Word> words = analyzer.analyze();
        Assertions.assertFalse(words.isEmpty());
    }
}
