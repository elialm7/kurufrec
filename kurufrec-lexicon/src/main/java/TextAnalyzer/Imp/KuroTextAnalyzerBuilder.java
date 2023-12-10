package TextAnalyzer.Imp;

import KanaConversion.KanaConversion;

public class KuroTextAnalyzerBuilder {

    private String content;
    private KanaConversion converter;

    private boolean searchmode = false;
    private boolean extendedmode = false;
    private KuroTextAnalyzerBuilder(String input){
        this.content = input;
    }

    public static KuroTextAnalyzerBuilder builder(String input){
        return new KuroTextAnalyzerBuilder(input);
    }
    public KuroTextAnalyzerBuilder withKanaConverter(KanaConversion converter){
        this.converter = converter;
        return this;
    }
    public KuroTextAnalyzer build(){
        return new KuroTextAnalyzer(content, converter);
    }





}
