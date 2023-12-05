package KanaConversion;

public interface KanaConversion {
    String romajiToHiragana(String input);
    String kanaToRomaji(String input);
    String romajiToKatakana(String input);
    boolean isKanji(String input);
    boolean isKatakana(String input);
    boolean isHiragana(String input);
    boolean isRomaji(String input);

}
