package Model.Lexicon.JpLexer;

import Model.DataAccess.Folder.MyFolder;
import Model.Error.ErrorType;
import Model.Error.KuruException;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class JpLexer {
    private Tokenizer kuroMojiTokenizer;

    public JpLexer() {
        this.kuroMojiTokenizer = new Tokenizer();
    }
    public List<Token> tokenize(File source){
        if(Objects.isNull(source)) throw new KuruException("the soorce file cannot be nulll", ErrorType.EXTERNAL );
        String tokenizableSource = resolveFile(source);
        return kuroMojiTokenizer.tokenize(tokenizableSource);
    }

    private String resolveFile(File input){
        if(!input.exists()) throw new KuruException("Given path doesn't exist.", ErrorType.EXTERNAL);
        if(input.isFile()){
           return resolveSourceFromFile(input);
        }
        return resolveSourceFromDirectory(input);
    }
    private String resolveSourceFromDirectory(File directory){
        if(!directory.canRead()) throw new KuruException("Cannot read the directory.", ErrorType.EXTERNAL);
        List<File> files = MyFolder.getFilePathList(directory);
        return MyFolder.getStringFromFiles((File[]) files.toArray());
    }
    private String resolveSourceFromFile(File file){
        if(!file.canRead()) throw new KuruException("Cannot read the file.", ErrorType.EXTERNAL);
        return MyFolder.getStringFromFile(file);
    }

}
