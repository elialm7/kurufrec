package controller;

import FileIO.in.imp.SimpleFileReader;
import FileIO.out.imp.SimpleFileWriter;
import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.FrecuencierContext.Frecuencier;
import TextFrecuencier.FrecuencyStrategy.FrecuencyStrategy;
import TextFrecuencier.FrecuencyStrategy.WordFrecuencier.WordFrecuencyStrategy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private TextArea LogArea;

    @FXML
    private Button frecuencyStartButton;

    @FXML
    private Button openFileButton;

    @FXML
    private Label titleLabel;

    private Stage mainViewStage;

    private File jpFile;

    public void setMainViewStage(Stage st){
        this.mainViewStage = st;
    }
    private void openFile(){
        this.LogArea.clear();
        FileChooser chooser = new FileChooser();
        File selectedFile = chooser.showOpenDialog(mainViewStage);
        if(selectedFile == null)return;
        this.jpFile = selectedFile;
        this.LogArea.appendText(infoTextFormat("File: "+ selectedFile.getName() + " Selected. ")+"\n");
    }

    private String infoTextFormat(String content){
        return "INFO:"+content;
    }
    private String errorTextFormat(String content){
        return "ERROR:"+content;
    }


    private String contentBuilder(List<Word> words){
        StringBuilder builder = new StringBuilder();
        Iterator<Word> it = words.iterator();
        while(it.hasNext()) {
            Word w = it.next();
            builder.append(w.getContent() + ", "+w.getReading() + ", "+w.getRomaji()+ ", "+ w.getFrecuency());
            builder.append("\n");
        };

        return builder.toString();

    }

    private void renamefile(){
        Path inputPath = jpFile.toPath();
        Path parentDir = inputPath.getParent();
        String originalFileName = inputPath.getFileName().toString();
        int dotIndex = originalFileName.lastIndexOf(".");
        String baseName = (dotIndex == -1) ? originalFileName : originalFileName.substring(0, dotIndex);
        String extension = (dotIndex == -1) ? "" : originalFileName.substring(dotIndex);
        String newFileName = baseName + "(" + "result" + ")" + extension;
        Path renamedFilePath = parentDir.resolve(newFileName);
        this.jpFile = renamedFilePath.toFile();
    }
    private void savetoFile(List<Word> results) throws IOException {
        renamefile();
        SimpleFileWriter writer = new SimpleFileWriter(jpFile);
        writer.writeContent(contentBuilder(results));
        this.LogArea.appendText(infoTextFormat("file saved to: "+jpFile.getAbsolutePath())+"\n");
    }
    private void startFrecuency(){
        try {
            this.LogArea.appendText(infoTextFormat("Preparing objects...")+"\n");
            SimpleFileReader reader = new SimpleFileReader(this.jpFile);
            TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(reader.readContent()).build();
            FrecuencyStrategy<Word> frecuencyStrategy = new WordFrecuencyStrategy(analyzer);
            frecuencyStrategy.addObserver(( state, message) -> LogArea.appendText(infoTextFormat( state.toString()+ ": "+message)+"\n"));
            Frecuencier<Word> frecuencierContext = new Frecuencier<>();
            frecuencierContext.setStrategy(frecuencyStrategy);
            this.LogArea.appendText(infoTextFormat("Doing frecuency...")+"\n");
            List<Word> results = frecuencierContext.doFrecuency();
            savetoFile(results);
        }catch (IOException e){
            this.LogArea.appendText(errorTextFormat(e.getMessage()));
        }

    }
    private void setEvents(){
        this.openFileButton.setOnAction(actionEvent -> {openFile();});
        this.frecuencyStartButton.setOnAction(actionEvent -> {startFrecuency();});
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEvents();
        this.LogArea.setEditable(false);
    }
}
