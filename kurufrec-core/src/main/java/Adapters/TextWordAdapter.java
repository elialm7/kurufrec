package Adapters;

import Core.KuroIpadicTokenFrecuency;
import Domains.TextWord;

public class TextWordAdapter{


    public static TextWord of(KuroIpadicTokenFrecuency frecuencyToken){
        return new TextWord(
                frecuencyToken.token().surface(),
                frecuencyToken.token().speechpart(),
                frecuencyToken.token().conjugationForm() + " | "+frecuencyToken.token().conjugationType(),
                frecuencyToken.token().baseform(),
                frecuencyToken.frecuency()
        );
    }

}
