package Model.FileIO.in;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public abstract class KuruReader<T> {

    protected Charset charset = StandardCharsets.UTF_8;

    public void setCharSet(Charset charset){
        this.charset = charset;
    }

   public abstract T readContent() throws IOException;
}
