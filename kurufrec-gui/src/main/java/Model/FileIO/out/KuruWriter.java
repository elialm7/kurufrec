package Model.FileIO.out;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class KuruWriter<T> {

    protected Charset charset = StandardCharsets.UTF_8;

    public void setCharset(Charset charset){
        this.charset = charset;
    }

    public abstract void writeContent(T input) throws IOException;


}
