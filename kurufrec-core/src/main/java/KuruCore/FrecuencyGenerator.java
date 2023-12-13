package KuruCore;

import FileIO.in.imp.SimpleFileReader;
import FileIO.out.imp.SimpleFileWriter;
import KanaConversion.Imp.KanaConversionKuru;
import KanaConversion.Imp.KanaConversionKuruFactory;
import KanaConversion.KanaConversionFactory;
import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier;
import TextFrecuencier.WordFrecuencier.WordFrecuencierBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FrecuencyGenerator {


    private File inputFile;
    private File outputFile;
    public FrecuencyGenerator(){}

    public void prepareforFrecuency(File inputFile, File outputResult){
        this.inputFile = inputFile;
        this.inputFile = inputFile;
    }


    private boolean isDirectory(File path){
        return path.isDirectory();
    }


    private String readInput(File Input){
        try {
            SimpleFileReader fileReader = new SimpleFileReader(inputFile);
            return fileReader.readContent();
        }catch (IOException exception){
            System.out.println(exception.getMessage() + " : " + exception.getClass().getSimpleName());
        }
        return "";
    }

    private String formattedResult(List<Word> results){
        StringBuilder formattedString = new StringBuilder();
        Iterator<Word> wordIterator = results.iterator();
        formattedString.append("Word, Type, Reading, Romaji, CountedFrecuency").append("\n");
        while(wordIterator.hasNext()){
            Word currentword = wordIterator.next();
            formattedString.append(currentword.getContent()).append(",");
            formattedString.append(currentword.getType()).append(",");
            formattedString.append(currentword.getReading()).append(",");
            formattedString.append(currentword.getRomaji()).append(",");
            formattedString.append(currentword.getFrecuency()).append("\n");
            //added new comments
        }
        return formattedString.toString();
    }


    public void startFrecuency(){
        log("Instanciation Objects. ");
        TextAnalyzer<Word> analyzer  = KuroTextAnalyzerBuilder.builder(readInput(inputFile))
                .withKanaConverter(new KanaConversionKuruFactory().createKanaConverter()).build();
        log("TextAnalyzer Prepared.");
        Frecuencier<Word> wordFrecuencier = WordFrecuencierBuilder.builder().withAnalyzer(analyzer).build();
        log("Frecuencier Prepared");
        log("Starting Frecuency Process.");
        List<Word> results = wordFrecuencier.doFrecuency();
        log("Frecuency Finished.");
        log("Formatting Results.");
        String finalresult = formattedResult(results);
        log("Saving results.");
        saveResult(finalresult);
        log("Process Done. Results saved to: "+outputFile.getAbsolutePath());
    }

    private void log(String input){

        System.out.println(input);

    }


    private  void saveResult(String result){
        try {
            SimpleFileWriter resultWriter = new SimpleFileWriter(outputFile);
            resultWriter.writeContent(result);
        }catch (IOException io){
            System.out.println(io.getMessage() + " : "+io.getClass().getSimpleName());
        }

    }







}
