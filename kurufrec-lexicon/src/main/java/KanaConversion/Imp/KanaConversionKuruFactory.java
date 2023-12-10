package KanaConversion.Imp;

import KanaConversion.KanaConversion;
import KanaConversion.KanaConversionFactory;

public class KanaConversionKuruFactory implements KanaConversionFactory {

    @Override
    public KanaConversion createKanaConverter() {
        return  new KanaConversionKuru();
    }
}
