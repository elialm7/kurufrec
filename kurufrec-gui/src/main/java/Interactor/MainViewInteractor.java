package Interactor;
import TextAnalyzer.Imp.KuroTextAnalyzerBuilder;
import TextAnalyzer.TextAnalyzer;
import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier.Frecuencier;
import TextFrecuencier.Frecuencier.WordFrecuencier.WordFrecuencier;
import UIStateModel.MainViewStateModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public void executeFrecuency() {
        TextAnalyzer<Word> analyzer = KuroTextAnalyzerBuilder.builder("").build();
        WordFrecuencier frecuencier = new WordFrecuencier(analyzer);
        frecuencier.addListener((event, origin) -> {
            updateLogAreaStateModel(event);
        });
        frecuencier.execute();
    }
    private void updateLogAreaStateModel(Frecuencier.Event event) {
        mainViewStateModel.appendlogAreaText(event.toString());
    }
}
