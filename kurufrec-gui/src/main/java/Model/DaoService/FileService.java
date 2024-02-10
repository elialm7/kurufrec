package Model.DaoService;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileService {
    private static FileService instance;
    private FileService(){

    }
    public static FileService getInstance(){
        return new FileService();
    }


    public File renameFile(File toberaname, String newName){


        return null;


    }

    public void saveAsHtmlFile(String input, File destination){





    }
    public String readContentFromFile(File origin) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(origin), StandardCharsets.UTF_8));
        String line;
        while((line = br.readLine()) != null){
            sb.append(line).append("\n");

        }
        br.close();
        return sb.toString();
    }

}
