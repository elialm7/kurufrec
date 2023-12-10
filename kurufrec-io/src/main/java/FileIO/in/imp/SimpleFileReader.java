package FileIO.in.imp;

import FileIO.in.KuruReader;

import java.io.*;

public class SimpleFileReader extends KuruReader<String> {

    private File inputFile;
    public SimpleFileReader(File filepath){
        this.inputFile = filepath;
    }

    @Override
    public String readContent() throws IOException {
        if(inputFile == null) throw new NullPointerException("File input is null, provide an file in order to read");
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), charset));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        return sb.toString();
    }
}
