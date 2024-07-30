package Api;

import java.util.List;

public interface TextFrecuencier<O, I> {
    List<O> PerformFrecuency(List<I> inputlist);
}
