package Api;

import java.util.List;

public interface TextTokenizer<T>  {

    List<T> analyze(String text);

}
