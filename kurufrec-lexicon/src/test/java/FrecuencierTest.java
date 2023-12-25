import KanaConversion.Imp.KanaConversionKuruFactory;
import KanaConversion.KanaConversion;
import KanaConversion.KanaConversionFactory;

import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier;
import TextFrecuencier.WordFrecuencier.WordFrecuencierBuilder;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FrecuencierTest {

    @Test
    public void testDefaultFrecuencier(){
        TextAnalyzer<Word> analyer = KuroTextAnalyzerBuilder.builder("eee感情的に毎日を感情的にを感情的に毎日").build();
        Frecuencier<Word> frecuencier = WordFrecuencierBuilder.builder().withAnalyzer(analyer).build();
        List<Word> finalList = frecuencier.doFrecuency();
        finalList.forEach(e-> System.out.println(e.getContent() + " => "+e.getReading() + " => "+e.getRomaji()+" => "+e.getFrecuency()));
    }




}
