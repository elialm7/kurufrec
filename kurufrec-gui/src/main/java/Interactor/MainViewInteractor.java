package Interactor;
import FileIO.in.imp.SimpleFileReader;
import FileIO.out.imp.SimpleFileWriter;
import TextEntities.Word.Word;
import controller.MainViewController;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

// todo: finish the logic bussines for the application.
public class MainViewInteractor {

    private MainViewController mainViewController;
    public void setController(MainViewController controller) {
            this.mainViewController = controller;
    }

    public void show() {
        mainViewController.show();
        bindActions();
    }

    private void bindActions(){
            mainViewController.setOpenFileButtonAction(actionEvent -> openfile());
            mainViewController.setFrecuencyStartButtonAction( actionEvent -> startFrecuency());
    }

    private void startFrecuency(){

    }

    private void openfile(){}

    private String getFileContent(){
      /*  log.debug("getting file content.");
        String content = "";
        try {
            SimpleFileReader reader = new SimpleFileReader(this.jpFile);
            content = reader.readContent();
        } catch (IOException e) {
            updateLogArea(errorTextFormat("File cannot be read. check logs."));
            log.error("File could'nt be opened or read.", e);
        }
        return content;*/
        return null;
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
    private void savetoFile(List<Word> results) throws IOException {
      /*  renamefile();
        log.debug("Saving file");
        SimpleFileWriter writer = new SimpleFileWriter(jpFile);
        writer.writeContent(contentBuilder(results));
        updateLogArea(infoTextFormat("file saved to: " + jpFile.getAbsolutePath()));
        Openifselected();*/
    }

    private void renamefile() {
       /* log.debug("renaming file");
        Path inputPath = jpFile.toPath();
        Path parentDir = inputPath.getParent();
        String originalFileName = inputPath.getFileName().toString();
        int dotIndex = originalFileName.lastIndexOf(".");
        String baseName = (dotIndex == -1) ? originalFileName : originalFileName.substring(0, dotIndex);
        String extension = (dotIndex == -1) ? "" : originalFileName.substring(dotIndex);
        String newFileName = baseName + "(" + "result" + ")" + extension;
        Path renamedFilePath = parentDir.resolve(newFileName);
        this.jpFile = renamedFilePath.toFile();*/
    }
    private String contentBuilder(List<Word> words) {
       /* log.debug("Building content string");
        StringBuilder builder = new StringBuilder();
        Iterator<Word> it = words.iterator();
        while (it.hasNext()) {
            Word w = it.next();
            //    builder.append(w.getContent() + ", " + w.getReading() + ", " + w.getRomaji() + ", " + w.getFrecuency());
            builder.append("\n");
        }

        return builder.toString();*/
        return null;

    }

}
