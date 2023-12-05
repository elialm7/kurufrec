package KanaConversion.Imp;
import KanaConversion.CSVresourceService.CSVkanaMapper;
import KanaConversion.CSVresourceService.ConversionTable;
import KanaConversion.KanaConversion;


public class KanaConversionKuru implements KanaConversion {


    private final int MAX_LENGTH_WORD = 1;

     KanaConversionKuru() {
    }

    private boolean checkmaxlenght(String input) {
        char[] charInput = input.toCharArray();
        return charInput.length == MAX_LENGTH_WORD;
    }

    private Character.UnicodeBlock getUnicodeBlock(String character) {
        char[] arrchar = character.toCharArray();
        return Character.UnicodeBlock.of(arrchar[0]);
    }

    @Override
    public String romajiToHiragana(String input) {
         input = input.toLowerCase();
         input = replaceDoubleConsonantWithSokuonMarker(input , 'っ');
         input = replaceStringWithConversionTable(input, CSVkanaMapper.instance().RomajitoHiraganaTable());
         return input;
    }

    @Override
    public String kanaToRomaji(String input) {
        input = replaceStringWithConversionTable(input, CSVkanaMapper.instance().KanatoRomaji());
        input = replaceDashMarkerWithLongVowel(input);
        input = replaceSokuonMarkersWithDoubleConsonant(input);
        return input;
    }

    @Override
    public String romajiToKatakana(String input) {
        input = input.toLowerCase();
        input = replaceLongVowelWithDashMarker(input);
        input = replaceDoubleConsonantWithSokuonMarker(input, 'ッ');
        input = replaceStringWithConversionTable(input, CSVkanaMapper.instance().RomajitoKatanaTable());
        return input;
    }

    @Override
    public boolean isKanji(String input) {
        if (!checkmaxlenght(input)) return false;
        return getUnicodeBlock(input) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;
    }

    @Override
    public boolean isKatakana(String input) {
        if (!checkmaxlenght(input)) return false;
        return getUnicodeBlock(input) == Character.UnicodeBlock.KATAKANA;
    }

    @Override
    public boolean isHiragana(String input) {
        if (!checkmaxlenght(input)) return false;
        return getUnicodeBlock(input) == Character.UnicodeBlock.HIRAGANA;
    }

    @Override
    public boolean isRomaji(String input) {
        if (!checkmaxlenght(input)) return false;
        char[] arrchar = input.toCharArray();
        return arrchar[0] >= 'A' && arrchar[0] <= 'Z' || arrchar[0] >= 'a' && arrchar[0] <= 'z';
    }
    private String replaceStringWithConversionTable(String string, ConversionTable conversionTable) {

        StringBuilder resultBuilder = new StringBuilder();

        int currentOffset = 0;

        while (currentOffset < string.length()) {

            int maxSubstringLength = Math.min(conversionTable.getMaxlengt(), string.length() - currentOffset);

            // Look-up the longest substring match.
            for (int substringLength = maxSubstringLength; substringLength > 0; substringLength--) {

                String substring = string.substring(currentOffset, currentOffset + substringLength);
                String replacementString = conversionTable.valueof(substring);
                // Replace substring if there's a match.
                if (replacementString != null) {
                    resultBuilder.append(replacementString);

                    currentOffset += substring.length();
                    break;
                }

                // Keep original character if no match found.
                if (substringLength == 1) {
                    resultBuilder.append(substring);

                    currentOffset += 1;
                    break;
                }
            }
        }

        return resultBuilder.toString();
    }

    private String replaceLongVowelWithDashMarker(String string) {

        StringBuilder resultBuilder = new StringBuilder(string);

        for (int currentOffset = 1; currentOffset < string.length(); currentOffset++) {

            char currentCharacter = string.charAt(currentOffset);
            char previousCharacter = string.charAt(currentOffset - 1);

            if (isRomanVowel(currentCharacter) && currentCharacter == previousCharacter) {
                resultBuilder.deleteCharAt(currentOffset);
                resultBuilder.insert(currentOffset, 'ー');
            }
        }

        return resultBuilder.toString();
    }

    private String replaceDoubleConsonantWithSokuonMarker(String string, char sokuonMarker) {

        StringBuilder resultBuilder = new StringBuilder(string);

        for (int currentOffset = 1; currentOffset < string.length() - 1; currentOffset++) {

            char currentCharacter = string.charAt(currentOffset);
            char nextCharacter = string.charAt(currentOffset + 1);

            boolean isDoubleConsonant = currentCharacter == nextCharacter;
            boolean isExceptionalCase = currentCharacter == 't' && nextCharacter == 'c';

            if (isRomanConsonant(currentCharacter) && (isDoubleConsonant || isExceptionalCase)) {
                resultBuilder.deleteCharAt(currentOffset);
                resultBuilder.insert(currentOffset, sokuonMarker);
            }
        }

        return resultBuilder.toString();
    }

    private String replaceSokuonMarkersWithDoubleConsonant(String string) {

        StringBuilder resultBuilder = new StringBuilder(string);

        for (int currentOffset = 0; currentOffset < string.length() - 1; currentOffset++) {

            char currentCharacter = string.charAt(currentOffset);
            char nextCharacter = string.charAt(currentOffset + 1);

            boolean isSokuon = currentCharacter == 'ッ' || currentCharacter == 'っ';

            if (isSokuon && isRomanConsonant(nextCharacter)) {
                char replacementCharacter = nextCharacter == 'c' ? 't' : nextCharacter;

                resultBuilder.deleteCharAt(currentOffset);
                resultBuilder.insert(currentOffset, replacementCharacter);
            }
        }

        return resultBuilder.toString();
    }

    private String replaceDashMarkerWithLongVowel(String string) {

        StringBuilder resultBuilder = new StringBuilder(string);

        for (int currentOffset = 1; currentOffset < string.length(); currentOffset++) {

            char currentCharacter = string.charAt(currentOffset);
            char previousCharacter = string.charAt(currentOffset - 1);

            if (currentCharacter == '-' && isRomanVowel(previousCharacter)) {

                resultBuilder.deleteCharAt(currentOffset);
                resultBuilder.insert(currentOffset, previousCharacter);
            }
        }

        return resultBuilder.toString();
    }

    private static boolean isRomanConsonant(char character) {
        return character >= 'a' && character <= 'z' && ! isRomanVowel(character);
    }

    private static boolean isRomanVowel(char character) {
        return character == 'a' || character == 'i' || character == 'u' || character == 'e' || character == 'o';
    }
}
