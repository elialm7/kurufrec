package KuroMoji;


public record IpadicTokenizerConfig(Boolean allowNakaguro,
                                               IpadicTokenizerMode mode,
                                               Integer kanjiPenaltyLengthThreshold,
                                               Integer kanjiPenalty,
                                               Integer otherPenaltyLengthThreshold,
                                               Integer otherPenalty) {

    public static IpadicTokenizerMode DEFAULT_MODE = IpadicTokenizerMode.NORMAL;
    public static Boolean DEFAULT_ALLOW_NAKAGURO_SPLIT = false;
    public static Integer DEFAULT_KANJI_PENALTY_LENGTH_TRESHOLD = 2;
    public static Integer DEFAULT_KANJI_PENALTY = 3000;
    public static Integer DEFAULT_OTHER_PENALTY_LENGTH_THRESHOLD = 7;
    public static Integer DEFAULT_OTHER_PENALTY = 1700;


    public static IpadicTokenizerConfig Default(){
        return new IpadicTokenizerConfig(
                IpadicTokenizerConfig.DEFAULT_ALLOW_NAKAGURO_SPLIT,
                IpadicTokenizerConfig.DEFAULT_MODE, 
                IpadicTokenizerConfig.DEFAULT_KANJI_PENALTY_LENGTH_TRESHOLD,
                IpadicTokenizerConfig.DEFAULT_KANJI_PENALTY,
                IpadicTokenizerConfig.DEFAULT_OTHER_PENALTY_LENGTH_THRESHOLD,
                IpadicTokenizerConfig.DEFAULT_OTHER_PENALTY
        );

    }
}
