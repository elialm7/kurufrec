package TextAnalyzer.Imp;

import KanaConversion.KanaConversion;

public class KuroTextAnalyzerBuilder {

    private String content;
    private KanaConversion converter;

    private KuroTextAnalyzer.TextAnalyzerMode mode;

    private boolean allowNakaguroSplit = false;

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
    public KuroTextAnalyzerBuilder withMode(KuroTextAnalyzer.TextAnalyzerMode mode){
        this.mode = mode;
        return this;
    }

    public KuroTextAnalyzerBuilder withNakaguroSplit(boolean split){
        this.allowNakaguroSplit = split;
        return this;
    }
    public KuroTextAnalyzer build(){
        return new KuroTextAnalyzer(content, converter, mode, allowNakaguroSplit);
    }





}
