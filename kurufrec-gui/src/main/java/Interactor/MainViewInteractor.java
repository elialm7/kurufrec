package Interactor;
import FileIO.in.imp.SimpleFileReader;
import FileIO.out.imp.SimpleFileWriter;
import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier.Frecuencier;
import TextFrecuencier.Frecuencier.WordFrecuencier.WordFrecuencier;
import UIStateModel.MainViewStateModel;
import Utils.kuromoji.KuroSpeechParts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

// todo: finish the logic bussines for the application.
public class MainViewInteractor {
    private static Logger log = LogManager.getLogger(MainViewInteractor.class);
    private MainViewStateModel mainViewStateModel;

    public MainViewInteractor(MainViewStateModel stateModel) {
            this.mainViewStateModel = stateModel;
    }
    private void Openifselected(){
       /* log.debug("checking if the open after saving is selected.");
        if(this.openfinishing.isSelected()){
            updateLogArea(infoTextFormat("Opening the file."));
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(this.jpFile.toURI());
            } catch (IOException e) {
                updateLogArea(errorTextFormat("An error occurred while opening the file, check logs."));
                log.error("File can not be opened.", e);
            }
        }*/
    }

    // todo: move this into its own class or dao, or servtice, etc.
    private String readfile(){
        try{
            SimpleFileReader reader = new SimpleFileReader(this.mainViewStateModel.getSelectedfile());
            return reader.readContent();
        }catch (IOException e){
            log.error("Error reading the file", e);
        }
        return "";
    }

    private String transformIntoAformattedString(Map<Word, Integer> result){
        List<String> toWriteResult = new ArrayList<>();
        StringBuilder record = new StringBuilder();
        record.append("[SURFACE]")
                .append(", ").append("[BASEFORM]")
                .append(", ").append("[READING]")
                .append(", ").append("[PRONUNCIATION]")
                .append(", ").append("[PART OF SPEECH]")
                .append(", ").append("[FRECUENCY]")
                .append("\n");
        result.forEach((word, integer) -> {
            if(!word.getSurface().isEmpty() || !word.getSurface().isBlank()) {
                record.append(word.getSurface())
                        .append(", ").append(word.getBaseform())
                        .append(", ").append(word.getReading()).append(", ")
                        .append(word.getPronunciation())
                        .append(", ").append(word.getPartofspeech())
                        .append(", ").append(integer)
                        .append("\n");
            }
        });
        return record.toString();
    }


    // todo: implement the sorting by value
    private Map<Word, Integer> sortDescending(Map<Word, Integer> inputmap){
        return null;
    }

    // todo: implement the separation of the whole map into different maps with different word types grouped together and sorted also.
    private Map<Word, Integer> separatebytype(KuroSpeechParts type, Map<Word, Integer> input){
        return null;
    }

    // todo: move this method into its own class or service or dao, etc.
    private void writeToFile(File outputfile, String tobesave){
        try{
            SimpleFileWriter writer = new SimpleFileWriter(outputfile);
            writer.writeContent("");
        }catch (IOException e){
            log.error("there was an error while writing the file. ", e);
        }

    }
    public void executeFrecuency() {
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(readfile()).build();
        WordFrecuencier frecuencier = new WordFrecuencier(analyzer);
        frecuencier.addListener((event, origin) -> {
            updateLogAreaStateModel(event);
            int at = ((Frecuencier) origin).getCurrent() + 1;
            int of = ((Frecuencier) origin).getMax();
            updateProgressLabelStateModel(at, of);
        });
        Map<Word, Integer> result = frecuencier.execute();
        // todo: check if separation is need, and then do the sorting and then open the file/s.
        System.out.println(transformIntoAformattedString(result));
        mainViewStateModel.setFrecuencyRunning(false);
    }
    private void updateLogAreaStateModel(Frecuencier.Event event) {
        if(!mainViewStateModel.getlastAreaTextUpdate().equalsIgnoreCase(event.toString())){
            mainViewStateModel.appendlogAreaText(event.toString());
        }
    }
    private void updateProgressLabelStateModel(int at, int of){
        mainViewStateModel.setProgresslabel("Word: "+ at + " from " +of);
    }
}
