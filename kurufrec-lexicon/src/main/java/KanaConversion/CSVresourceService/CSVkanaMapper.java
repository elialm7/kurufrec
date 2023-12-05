package KanaConversion.CSVresourceService;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

public class CSVkanaMapper {


    private final String KANA_TO_ROMAJI = "/kana_to_romaji.csv";
    private final String ROMAJI_TO_HIRAGANA = "/romaji_to_hiragana.csv";
    private final String ROMAJI_TO_KATANA = "/romaji_to_katakana.csv";
    private static volatile CSVkanaMapper kanaInstance;

    private ConversionTable kanaRomaji;
    private ConversionTable romajiHiragana;
    private ConversionTable romajiKatana;
    private CSVkanaMapper(){}

    public synchronized static CSVkanaMapper instance(){
        if(kanaInstance == null){
            kanaInstance = new CSVkanaMapper();
        }
        return kanaInstance;
    }


    public ConversionTable KanatoRomaji(){
        if(kanaRomaji == null){
            kanaRomaji = loadTable(KANA_TO_ROMAJI);
        }
        return kanaRomaji;
    }

    public ConversionTable RomajitoHiraganaTable(){

        if(romajiHiragana == null){
            romajiHiragana =  loadTable(ROMAJI_TO_HIRAGANA);
        }

        return romajiHiragana;
    }

    public ConversionTable RomajitoKatanaTable(){
        if(romajiKatana==null){
            romajiKatana = loadTable(ROMAJI_TO_KATANA);
        }
        return romajiKatana;
    }

    private ConversionTable loadTable(String csvFile){
        URL resourceUrl = CSVkanaMapper.class.getResource(csvFile);
        Map<String, String> conversionMap = new TreeMap<String, String>();
        try (InputStream inputStream = resourceUrl.openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                int delimiterIndex = line.indexOf(',');
                String key = line.substring(0, delimiterIndex);
                String value = line.substring(delimiterIndex + 1);
                conversionMap.put(key, value);
            }
            return new ConversionTable(conversionMap);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return new ConversionTable(conversionMap);
    }


}
