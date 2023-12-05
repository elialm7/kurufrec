package TextAnalyzer;


public interface TextAnalyzerFactory {
    <T> TextAnalyzer<T> createAnalyzer(String input);
}
