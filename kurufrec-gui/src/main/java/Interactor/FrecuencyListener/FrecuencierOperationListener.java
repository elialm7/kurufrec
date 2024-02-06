package Interactor.FrecuencyListener;

import TextEntities.Word.Word;
import TextFrecuencier.Frecuencier.Frecuencier;
import TextFrecuencier.Frecuencier.WordFrecuencier.WordFrecuencier;
import TextFrecuencier.FrecuencierListener.FrecuencierListener;
import View.ViewState.MainView.ReportMainViewState;

public class FrecuencierOperationListener implements FrecuencierListener {

    private ReportMainViewState ReportState;
    public FrecuencierOperationListener(ReportMainViewState report){
        this.ReportState= report;
    }


    @Override
    public void handleEvent(Frecuencier.Event event, Object origin) {
        if(origin instanceof WordFrecuencier && !event.equals(Frecuencier.Event.PREPARING)){
            WordFrecuencier frecuencier = (WordFrecuencier) origin;
            int current = frecuencier.getCurrent();
            int max = frecuencier.getMax();
            ReportState.appendtoReportText(event.toString());
            ReportState.setProgressText("Word: "+(current+1) + " of "+max);
            if(max > 0){
                double progress = (double) current /max;
                ReportState.setProgressValue(progress);
            }
        }

    }
}
