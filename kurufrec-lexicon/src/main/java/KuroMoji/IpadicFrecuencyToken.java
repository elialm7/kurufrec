package KuroMoji;

import java.util.Objects;

public record IpadicFrecuencyToken(IpadicToken token, Integer frecuency) {
    public IpadicFrecuencyToken {
        Objects.requireNonNull(token);
        Objects.requireNonNull(frecuency);
    }
}
