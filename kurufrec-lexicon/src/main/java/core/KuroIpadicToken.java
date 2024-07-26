package core;

import java.util.Objects;

public record KuroIpadicToken(String surface,
                              String speechpart,
                              String baseform,
                              String conjugationForm,
                              String conjugationType,
                              String reading,
                              String pronunciation) {


    public static KuroIpadicToken UndefinedToken(){
        return new KuroIpadicToken(
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED",
                "UNDEFINED"
        );
    }

}
