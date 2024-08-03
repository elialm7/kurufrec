package Core;

import java.util.Objects;

public record KuroIpadicTokenFrecuency(KuroIpadicToken token, Integer frecuency) {
    public KuroIpadicTokenFrecuency {
        Objects.requireNonNull(token);
        Objects.requireNonNull(frecuency);
    }
}
