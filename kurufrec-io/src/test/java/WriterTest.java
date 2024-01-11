import FileIO.out.imp.SimpleFileWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class WriterTest {



    @Test
    public void shouldwriteonfile(){
        SimpleFileWriter writer = new SimpleFileWriter(new File("result.txt"));
        try{
            String content = "content";
            writer.writeContent(content);
            Assertions.assertTrue(new File("result.txt").exists());
        } catch (IOException e) {
            Assertions.fail();
        }
    }


}
