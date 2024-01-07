package controller;

import FileIO.in.imp.SimpleFileReader;
import FileIO.out.imp.SimpleFileWriter;
import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier.Frecuencier;
import TextFrecuencier.FrecuencyObservers.FrecuencyObserver;
import TextFrecuencier.FrecuencyStrategy.FrecuencyStrategy;
import TextFrecuencier.FrecuencyStrategy.WordFrecuencier.WordFrecuencyStrategy;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainViewController implements Initializable {

    @FXML
    private TextArea LogArea;

    @FXML
    private Button frecuencyStartButton;

    @FXML
    private Button openFileButton;

    @FXML
    private CheckBox openfinishing;

    @FXML
    private Label statelabel;
    private Stage mainViewStage;

    private File jpFile;

    public void setMainViewStage(Stage st) {
        this.mainViewStage = st;
    }

    private void openFile() {
        this.LogArea.clear();
        FileChooser chooser = new FileChooser();
        File selectedFile = chooser.showOpenDialog(mainViewStage);
        if (selectedFile == null) {
            updateLogArea(infoTextFormat("No file selected... "));
            return;
        }
        this.jpFile = selectedFile;
        updateLogArea(infoTextFormat("File: " + selectedFile.getName() + " Selected. "));
    }

    private String infoTextFormat(String content) {
        return "INFO:" + content;
    }

    private String errorTextFormat(String content) {
        return "ERROR:" + content;
    }

    private String contentBuilder(List<Word> words) {
        StringBuilder builder = new StringBuilder();
        Iterator<Word> it = words.iterator();
        while (it.hasNext()) {
            Word w = it.next();
            builder.append(w.getContent() + ", " + w.getReading() + ", " + w.getRomaji() + ", " + w.getFrecuency());
            builder.append("\n");
        }

        return builder.toString();

    }

    private void renamefile() {
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
    public void updateLogArea(String text) {
        Platform.runLater(() -> this.LogArea.appendText(text + "\n"));
    }
    public void updatStateLable(int current, int max){
        Platform.runLater(() -> this.statelabel.setText("Word: " + current + " of "+ max + " Words."));
    }
    private void savetoFile(List<Word> results) throws IOException {
        renamefile();
        SimpleFileWriter writer = new SimpleFileWriter(jpFile);
        writer.writeContent(contentBuilder(results));
        updateLogArea(infoTextFormat("file saved to: " + jpFile.getAbsolutePath()));
        Openifselected();
    }

    private void Openifselected(){
        if(this.openfinishing.isSelected()){
            updateLogArea(infoTextFormat("Opening the file."));
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(this.jpFile.toURI());
            } catch (IOException e) {
                updateLogArea(errorTextFormat("An error occurred while opening the file: "+ e.getMessage()));
            }
        }
    }
    private void startFrecuency(){
        Task<List<Word>> frecuencyTask = new Task<>() {
            @Override
            protected List<Word> call() throws Exception {
                Frecuencier<Word> frecuencier = prepareFrecuencier(getFileContent());
                return frecuencier.doFrecuency();
            }
        };
        frecuencyTask.setOnSucceeded(event -> {
            try {
                savetoFile(frecuencyTask.getValue());
            } catch (IOException e) {
                updateLogArea(errorTextFormat(e.getMessage()));
                throw new RuntimeException(e);
            }
        });
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(frecuencyTask);
        service.shutdown();
    }



	private Frecuencier<Word> prepareFrecuencier(String content){
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder(content).build();
        FrecuencyStrategy<Word> strategy = new WordFrecuencyStrategy(analyzer);
       strategy.addObserver(new FrecuencyObserver() {
           @Override
           public void updateMessage(FrecuencyStrategy.State state, String message) {
               updateLogArea(infoTextFormat(state.toString() + " : "+message));
           }
           @Override
           public void updateProgress(int currentProgress, int maxProress) {
                updatStateLable(currentProgress, maxProress);
           }
       });
        Frecuencier<Word> frecuencier = new Frecuencier<>();
        frecuencier.setStrategy(strategy);
		return frecuencier;
	}


    private String getFileContent(){
        try {
            SimpleFileReader reader = new SimpleFileReader(this.jpFile);
            return reader.readContent();
        } catch (IOException e) {
            updateLogArea(errorTextFormat(e.getMessage()));
            throw new RuntimeException(e);
        }
    }



    private void setEvents() {
        this.openFileButton.setOnAction(actionEvent -> {
            openFile();
        });
        this.frecuencyStartButton.setOnAction(actionEvent -> {
            startFrecuency();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEvents();
        this.LogArea.setEditable(false);
    }
}
