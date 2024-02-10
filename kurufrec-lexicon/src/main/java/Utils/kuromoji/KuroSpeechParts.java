package Utils.kuromoji;

public enum KuroSpeechParts {



    NOUN("名詞", 0),
    VERB("動詞", 1),
    ADJECTIVE("形容詞", 2),
    PARTICLE("助詞", 3),
    ADVERB("副詞", 4),
    UNSUPPORTED("*", -1);

    private final String jpversion;
    private final int weight;
    public static int suuported = 5;
    public static KuroSpeechParts[] getAllSupported(){
        return new KuroSpeechParts[]{
          KuroSpeechParts.NOUN,
          KuroSpeechParts.VERB,
          KuroSpeechParts.ADJECTIVE,
          KuroSpeechParts.PARTICLE,
          KuroSpeechParts.ADVERB
        };
    }
    KuroSpeechParts(String jpversion, int weight){
        this.jpversion = jpversion;
        this.weight = weight;
    }

    public String getJpWord(){
        return this.jpversion;
    }
    public int getWeight(){
        return this.weight;
    }

}

