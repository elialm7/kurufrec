package KanaConversion.Imp;

import KanaConversion.KanaConversion;
import KanaConversion.KanaConversionFactory;

public class KanaConversionKuruFactory implements KanaConversionFactory {

    @Override
    public KanaConversion createKanaHelper() {
        return  new KanaConversionKuru();
    }
}
