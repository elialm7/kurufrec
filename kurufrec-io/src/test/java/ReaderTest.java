import FileIO.in.imp.SimpleFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ReaderTest {


    @Test
    public void shoudlreturnContent(){
        SimpleFileReader reader = new SimpleFileReader(new File(String.valueOf(getClass().getResource("test.txt"))));
        try{
            String content = reader.readContent();
            Assertions.assertFalse(content.isEmpty());
        } catch (IOException e) {
            Assertions.fail();
        }

    }


}
