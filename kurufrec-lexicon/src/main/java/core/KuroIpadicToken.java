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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KuroIpadicToken that = (KuroIpadicToken) o;
        return Objects.equals(surface, that.surface) && Objects.equals(reading, that.reading) && Objects.equals(baseform, that.baseform) && Objects.equals(speechpart, that.speechpart) && Objects.equals(pronunciation, that.pronunciation) && Objects.equals(conjugationForm, that.conjugationForm) && Objects.equals(conjugationType, that.conjugationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surface, speechpart, baseform, conjugationForm, conjugationType, reading, pronunciation);
    }
}
