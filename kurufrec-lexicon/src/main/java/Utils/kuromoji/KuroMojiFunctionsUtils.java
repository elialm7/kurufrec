package Utils.kuromoji;



public class KuroMojiFunctionsUtils {

   /* private KanaConversion conversionhelper;

    private KuroMojiFunctionsUtils(KanaConversion conversionhelper){
        this.conversionhelper = conversionhelper;
    }

    public static KuroMojiFunctionsUtils NewFunctionUtils(KanaConversion kanaConversion){
        return new KuroMojiFunctionsUtils(kanaConversion);
    }

    public static KuroMojiFunctionsUtils NewFunctionUtils(){
        KanaConversion defaultConverter = new KanaConversionKuruFactory().createKanaConverter();
        return new KuroMojiFunctionsUtils(defaultConverter);
    }

   /* public  Word fromToken(Token tk){
        WordBuilder builder = new WordBuilder();
        builder.withContent(tk.getSurface())
                .withReading(tk.getReading())
                .withType(tk.getPartOfSpeechLevel1())
                .withPronunciation(tk.getPronunciation())
              //  .withRomaji(getRomaji(tk.getReading()))
                .withFrecuency(0)
                .withWeight(getWeight(tk.getPartOfSpeechLevel1()));
        return builder.build();
    }

    private String getRomaji(String input){
        if(conversionhelper == null){
            return "...";
        }
        return conversionhelper.kanaToRomaji(input);

    }

    public List<Word> fromTokens(List<Token> tokens){
        List<Word> wordsfromtks = new ArrayList<>();
       // tokens.forEach(tk -> wordsfromtks.add(fromToken(tk)));
        return wordsfromtks;
    }
    private int getWeight(String type){

        int finalweight = SpeechWeights.NO_DEFINED_WEIGH;
        switch (type){
            case KuroMojiSpeechParts.KURO_JP_PARTICLE:
                finalweight = SpeechWeights.PARTICLE_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_NOUN:
                finalweight = SpeechWeights.NOUN_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_ADJECTIVE:
                finalweight = SpeechWeights.ADJECTIVE_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_AUXILIARY_VERB:
                finalweight = SpeechWeights.AUXILIARY_VERB_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_SYMBOL:
                finalweight = SpeechWeights.SYMBOL_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_ADVERB:
                finalweight = SpeechWeights.ADVERB_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_ADNOMINAL_ADJECTIVE:
                finalweight = SpeechWeights.ADNOMINAL_ADJECTIVE_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_INTERJECTION:
                finalweight = SpeechWeights.INTERJECTION_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_PREFIX:
                finalweight = SpeechWeights.PREFIX_WEIGH;
                break;
            case KuroMojiSpeechParts.KURO_JP_CONJUNCTION:
                finalweight = SpeechWeights.CONJUNCTION_WEIGH;
                break;
        }
        return finalweight;

    }


*/
}
