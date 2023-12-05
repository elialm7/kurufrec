import KanaConversion.Imp.KanaConversionKuruFactory;
import KanaConversion.KanaConversion;
import KanaConversion.KanaConversionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KanaHelperTest {


    KanaConversion converter;

    public KanaHelperTest(){
        KanaConversionFactory factory = new KanaConversionKuruFactory();
        converter = factory.createKanaHelper();
    }

    @Test
    public void RomajiToKatana() {
        assertEquals("カタカナ", converter.romajiToKatakana("katakana"));
        assertEquals("カタカナ", converter.romajiToKatakana("KATAKANA"));
        assertEquals("ホンコン", converter.romajiToKatakana("honkon"));
        assertEquals("コンバーター", converter.romajiToKatakana("konba-ta-"));
        assertEquals("コンバーター", converter.romajiToKatakana("konbaataa"));
        assertEquals("ドラッグ", converter.romajiToKatakana("doraggu"));
        assertEquals("メッシュ", converter.romajiToKatakana("messhu"));
        assertEquals("フェイスブック", converter.romajiToKatakana("feisubukku"));
        assertEquals("パーティー", converter.romajiToKatakana("paathii"));
        assertEquals("ジェット", converter.romajiToKatakana("jetto"));
    }

    @Test
    public void RomajiToHiragana() {
        assertEquals("ひらがな", converter.romajiToHiragana("hiragana"));
        assertEquals("ひらがな", converter.romajiToHiragana("HIRAGANA"));
        assertEquals("しんばし", converter.romajiToHiragana("shinbashi"));
        assertEquals("しんばし", converter.romajiToHiragana("shimbashi"));
        assertEquals("おばあさん", converter.romajiToHiragana("obaasan"));
        assertEquals("まっくら", converter.romajiToHiragana("makkura"));
        assertEquals("まっちゃ", converter.romajiToHiragana("maccha"));
        assertEquals("まっちゃ", converter.romajiToHiragana("matcha"));
        assertEquals("ひきつづき", converter.romajiToHiragana("hikitsuduki"));
        assertEquals("ひきつづき", converter.romajiToHiragana("hikitsudzuki"));
        assertEquals("そらをとぶ", converter.romajiToHiragana("sorawotobu"));
        assertEquals("なんやかんや", converter.romajiToHiragana("nan'yakan'ya"));
        assertEquals("じょうだん", converter.romajiToHiragana("joudan"));
    }

    @Test
    public void KatakanaToRomaji() {
        assertEquals("katakana", converter.kanaToRomaji("カタカナ"));
        assertEquals("honkon", converter.kanaToRomaji("ホンコン"));
        assertEquals("konbaataa", converter.kanaToRomaji("コンバーター"));
        assertEquals("doraggu", converter.kanaToRomaji("ドラッグ"));
        assertEquals("messhu", converter.kanaToRomaji("メッシュ"));
        assertEquals("feisubukku", converter.kanaToRomaji("フェイスブック"));
        assertEquals("paathii", converter.kanaToRomaji("パーティー"));
    }

    @Test
    public void HiraganaToRomaji() {
        assertEquals("hiragana", converter.kanaToRomaji("ひらがな"));
        assertEquals("shinbashi", converter.kanaToRomaji("しんばし"));
        assertEquals("obaasan", converter.kanaToRomaji("おばあさん"));
        assertEquals("makkura", converter.kanaToRomaji("まっくら"));
        assertEquals("matcha", converter.kanaToRomaji("まっちゃ"));
        assertEquals("hikitsudzuki", converter.kanaToRomaji("ひきつづき"));
        assertEquals("sorawotobu", converter.kanaToRomaji("そらをとぶ"));
        assertEquals("annai", converter.kanaToRomaji("あんない"));
        assertEquals("kan'i", converter.kanaToRomaji("かんい"));
        assertEquals("nan'yakan'ya", converter.kanaToRomaji("なんやかんや"));
    }
}
