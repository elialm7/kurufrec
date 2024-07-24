package core;

public record KuroIpadicTokenizerConfiguration(Boolean allowNakaguro,
                                               KuroIpadicTextTokenizerMode mode,
                                               Integer kanjiPenaltyLengthThreshold,
                                               Integer kanjiPenalty,
                                               Integer otherPenaltyLengthThreshold,
                                               Integer otherPenalty) {

    public static KuroIpadicTextTokenizerMode DEFAULT_MODE = KuroIpadicTextTokenizerMode.NORMAL;
    public static Boolean DEFAULT_ALLOW_NAKAGURO_SPLIT = false;
    public static Integer DEFAULT_KANJI_PENALTY_LENGTH_TRESHOLD = 2;
    public static Integer DEFAULT_KANJI_PENALTY = 3000;
    public static Integer DEFAULT_OTHER_PENALTY_LENGTH_THRESHOLD = 7;
    public static Integer DEFAULT_OTHER_PENALTY = 1700;


    public static KuroIpadicTokenizerConfiguration Default(){
        return new KuroIpadicTokenizerConfiguration(
                KuroIpadicTokenizerConfiguration.DEFAULT_ALLOW_NAKAGURO_SPLIT,
                KuroIpadicTokenizerConfiguration.DEFAULT_MODE, 
                KuroIpadicTokenizerConfiguration.DEFAULT_KANJI_PENALTY_LENGTH_TRESHOLD,
                KuroIpadicTokenizerConfiguration.DEFAULT_KANJI_PENALTY,
                KuroIpadicTokenizerConfiguration.DEFAULT_OTHER_PENALTY_LENGTH_THRESHOLD,
                KuroIpadicTokenizerConfiguration.DEFAULT_OTHER_PENALTY
        );

    }
}
