package FileIO.out.imp;

import FileIO.out.KuruWriter;

import java.io.*;

public class SimpleFileWriter extends KuruWriter<String> {

    private File outputfile;
    public SimpleFileWriter(File outfile){
        this.outputfile = outfile;
    }
    @Override
    public void writeContent(String input) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfile), charset));
        bufferedWriter.write(input);
        bufferedWriter.close();
    }
}
