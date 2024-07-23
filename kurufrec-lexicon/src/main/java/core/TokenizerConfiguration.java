package core;

public class TokenizerConfiguration {

    private Boolean allowNakaguro = false;
    private KuroIpadicTextTokenizerMode mode = KuroIpadicTextTokenizerMode.NORMAL;
    private int kanjiPenaltyLengthTreshold = 2;
    private int kanjiPenalty = 3000;
    private int otherPenaltyLengthThreshold = 7;
    private int otherPenalty = 1700;


    public TokenizerConfiguration(Boolean allowNakaguro,
                                  KuroIpadicTextTokenizerMode mode,
                                  int kanjiPenaltyLengthTreshold,
                                  int kanjiPenalty,
                                  int otherPenaltyLengthThreshold,
                                  int otherPenalty) {
        this.allowNakaguro = allowNakaguro;
        this.mode = mode;
        this.kanjiPenaltyLengthTreshold = kanjiPenaltyLengthTreshold;
        this.kanjiPenalty = kanjiPenalty;
        this.otherPenaltyLengthThreshold = otherPenaltyLengthThreshold;
        this.otherPenalty = otherPenalty;
    }
    public TokenizerConfiguration(){}

    public Boolean allowNakaguro() {
        return allowNakaguro;
    }

    public KuroIpadicTextTokenizerMode mode() {
        return mode;
    }

    public int kanjiPenaltyLengthTreshold() {
        return kanjiPenaltyLengthTreshold;
    }

    public int kanjiPenalty() {
        return kanjiPenalty;
    }

    public int otherPenaltyLengthThreshold() {
        return otherPenaltyLengthThreshold;
    }

    public int otherPenalty() {
        return otherPenalty;
    }
}
