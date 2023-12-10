import KanaConversion.Imp.KanaConversionKuruFactory;
import KanaConversion.KanaConversion;
import KanaConversion.KanaConversionFactory;

import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier;
import TextFrecuencier.WordFrecuencier.WordFrecuencierBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

public class FrecuencierTest {
    List<String> resultlist;



    public void prepareResultforAssertion(){
        resultlist = new ArrayList<>();
        resultlist.add("感情");
        resultlist.add("的");
        resultlist.add("に");
        resultlist.add("毎日");
        resultlist.add("を");
    }

    @Test
    public void TestFrecuencier(){
        KanaConversionFactory converterFactory = new KanaConversionKuruFactory();
        KanaConversion converter = converterFactory.createKanaConverter();
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder("感情的に毎日を")
                        .withKanaConverter(converter)
                        .build();
        Frecuencier<Word> fr = WordFrecuencierBuilder.builder().withAnalyzer(analyzer).build();
        List<Word> results = fr.doFrecuency();
        prepareResultforAssertion();
        for(int index=0;index < results.size(); index++){
            if(!results.get(index).getContent().equalsIgnoreCase(resultlist.get(index))){
                Assertions.fail();
            }
        }
        System.out.println("Test passed.");
    }


    @Test
    public void TestResultsfromFrecuencier(){
        KanaConversionFactory convertFactoy = new KanaConversionKuruFactory();
        KanaConversion converter = convertFactoy.createKanaConverter();
        TextAnalyzer<Word> analyer = KuroTextAnalyzerBuilder.builder("eee感情的に毎日を感情的にを感情的に毎日").
                withKanaConverter(converter).build();
        Frecuencier<Word> frecuencier = WordFrecuencierBuilder.builder().withAnalyzer(analyer).build();
        List<Word> finalList = frecuencier.doFrecuency();
        finalList.forEach(e-> System.out.println(e.getContent() + " => "+e.getReading() + " => "+e.getRomaji()+" => "+e.getFrecuency()));
    }


}
