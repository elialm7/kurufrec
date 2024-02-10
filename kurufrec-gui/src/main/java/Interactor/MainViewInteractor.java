package Interactor;
import Model.FileIO.in.imp.SimpleFileReader;
import Model.FileIO.out.imp.SimpleFileWriter;
import Interactor.FrecuencyListener.FrecuencierOperationListener;

import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier.Frecuencier;
import TextFrecuencier.Frecuencier.WordFrecuencier.WordFrecuencier;
import View.ViewState.MainView.ActionsMainViewState;
import View.ViewState.MainView.OptionsMainViewState;
import View.ViewState.MainView.ReportMainViewState;
import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.function.BiConsumer;


// todo: finish the logic bussines for the application.
public class MainViewInteractor {
    private static Logger log = LogManager.getLogger(MainViewInteractor.class);
    private Map<Word, Integer> frecuencymap;
    private List<Pair<String, Map<Word, Integer>>> wordfilteredmap;
    private List<File> filestobeOpened = new ArrayList<>();

    private ActionsMainViewState ActionState;
    private ReportMainViewState ReportState;
    private OptionsMainViewState OptionState;



    private TextAnalyzer<Word> textAnalyzer;


    public void bindActionsState(ActionsMainViewState actionState){
        this.ActionState = actionState;
    }
    public void bindReportState(ReportMainViewState reportState){
        this.ReportState = reportState;
    }
    public void bindOptionsState(OptionsMainViewState optionState){
        this.OptionState = optionState;
    }

    private void openFile(File tobeOpen){
        try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(tobeOpen);
        } catch (IOException e) {
            log.error("error during openignthe file ", e);
        }
    }

    // todo: move this into its own class or dao, or servtice, etc.
    private String readfile(){
        try{
            SimpleFileReader reader = new SimpleFileReader(this.ActionState.getSelectedFile());
            return reader.readContent();
        }catch (IOException e){
            log.error("Error reading the file", e);
        }
        return "";
    }

    private String transformIntoAformattedString(Map<Word, Integer> result) {

        return generateHTML(result);
    }
    private String generateHTML(Map<Word, Integer> result){
        Document doc = Document.createShell("");
        Element table = doc.createElement("table");
        Element headerRow = doc.createElement("tr");
        String[] headers = {"Surface", "Base Form", "Reading", "Pronunciation", "Part of Speech", "Frequency"};
        for (String header : headers) {
            Element th = doc.createElement("th");
            th.text(header);
            headerRow.appendChild(th);
        }
        table.appendChild(headerRow);
        result.forEach((word, integer) -> {
            if(!word.getSurface().isEmpty() || !word.getSurface().isBlank()) {
                Element row = doc.createElement("tr");
                row.appendChild(createTableCell(doc, word.getSurface()));
                row.appendChild(createTableCell(doc, word.getBaseform()));
                row.appendChild(createTableCell(doc, word.getReading()));
                row.appendChild(createTableCell(doc, word.getPronunciation()));
                row.appendChild(createTableCell(doc, word.getPartofspeech()));
                row.appendChild(createTableCell(doc, "  "+integer.toString()));
                table.appendChild(row);
            }
        });
        doc.body().appendChild(table);
        return doc.html();
    }
    private static Element createTableCell(Document doc, String text) {
        Element cell = doc.createElement("td");
        cell.text(text);
        return cell;
    }


    private Map<Word, Integer> sortDescendingbyValue(Map<Word, Integer> inputmap){
        List<Map.Entry<Word, Integer>> list = new LinkedList<>(inputmap.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        HashMap<Word, Integer> temp = new LinkedHashMap<>();
        list.forEach(wordIntegerEntry -> temp.put(wordIntegerEntry.getKey(), wordIntegerEntry.getValue()));
        return temp;
    }
    private Map<Word, Integer> separatebytype(String type, Map<Word, Integer> input){
        Map<Word, Integer> filteredResult = new HashMap<>();
        input.forEach((word, integer) -> {
            if(word.getPartofspeech().equalsIgnoreCase(type)){
                filteredResult.put(word, integer);
            }
        });
        return filteredResult;
    }

    // todo: move this method into its own class or service or dao, etc.
    private void writeToFile(File outputfile, String tobesave){
        try{
            SimpleFileWriter writer = new SimpleFileWriter(outputfile);
            writer.writeContent(tobesave);
        }catch (IOException e){
            log.error("there was an error while writing the file. ", e);
        }
    }


    private void prepareTextAnalyzer(String content){
        this.textAnalyzer = KuroTextAnalyzerBuilder.builder(content).build();
    }

    private Frecuencier<Map<Word, Integer>> getFrecuencierinstance(){
        prepareTextAnalyzer(this.readfile());
        WordFrecuencier frecuencier = new WordFrecuencier(this.textAnalyzer);
        frecuencier.addListener(new FrecuencierOperationListener(ReportState));
        return frecuencier;
    }
    public boolean executeFrecuency() {
        try {
            Frecuencier<Map<Word, Integer>> frecuencier = getFrecuencierinstance();
            this.frecuencymap = frecuencier.execute();
        }catch (NullPointerException e){
            log.error("Nullpointer caught", e);
            return false;
        }
        return (frecuencymap != null )&&(!frecuencymap.isEmpty());
    }

    public void afterFrecuencyExecution(){
        if(Objects.isNull(frecuencymap)) return; // todo: improve error handling
        if(isFilteringActivated()){
            filterResultBytype();
            saveFilteredMaps();
            openFileIfselected();
        }else{
            saveWithoutFiltering();
            openFileIfselected();
        }
    }

    public void cleanup(){
        this.filestobeOpened = new ArrayList<>();
        this.frecuencymap = null;
        this.wordfilteredmap = null;
    }

    private void filterResultBytype(){

        this.wordfilteredmap = new ArrayList<>();
         Arrays.stream(this.textAnalyzer.getAllSpeechParts()).forEach(type -> {

             Map<Word, Integer> newMap = sortDescendingbyValue(separatebytype(type, frecuencymap));
             Pair<String, Map<Word, Integer>> pair = new Pair<>(type, newMap);
             wordfilteredmap.add(pair);
         });

    }

    private void saveFilteredMaps(){

        this.wordfilteredmap.forEach(stringMapPair -> {
            String filename = stringMapPair.getKey();
            String resultContent = transformIntoAformattedString(stringMapPair.getValue());
            File finaldestination = renameFilebasedonPrevious(ActionState.getSelectedFile(), filename);
            filestobeOpened.add(finaldestination);
            writeToFile(finaldestination, resultContent);
            notifyfilesaved(finaldestination.getName(), finaldestination.getParent());
        });

    }

    private File renameFilebasedonPrevious(File file, String betweenparen){
        String parentdirectory = file.getParent();
        String originalName = file.getName();
        int indexdot = originalName.indexOf(".");
        String nameNoExt = originalName.substring(0, indexdot);
        String ext = ".html";
        String finalname = nameNoExt + "("+betweenparen+")"+ext;
        String completepath = parentdirectory+"\\"+finalname;
        return new File(completepath);
    }
    private void saveWithoutFiltering(){
        String stringmaptransformation = transformIntoAformattedString(sortDescendingbyValue(frecuencymap));
        String filenameattachment = "result";
        File destination = renameFilebasedonPrevious(ActionState.getSelectedFile(), filenameattachment);
        writeToFile(destination, stringmaptransformation);
        notifyfilesaved(destination.getName(), destination.getParent());
        filestobeOpened.add(destination);
    }

    private void openFileIfselected(){
        if(!isOpeningAfterSelected()) return;
        filestobeOpened.forEach(file -> {
            notifyFileOpening(file.getName());
            openFile(file);
        });
    }


    private boolean isFilteringActivated(){
        return OptionState.getOnFilteringOption();
    }
    private boolean isOpeningAfterSelected(){
        return OptionState.getOnOpeningAfterOption();
    }

    private void notifyfilesaved(String filename, String path ){
        ReportState.appendtoReportText("Saved "+filename +" at "+ path);
    }

    private void notifyFileOpening(String filename){
        ReportState.appendtoReportText("Opening "+filename+"...");
    }

}
