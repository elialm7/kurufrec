package View.ViewState.MainView;

import View.ViewState.StateListenable;

public class ReportMainViewState extends StateListenable<ReportMainViewState> {

    private String reportText = "";
    private String lastUpdateOnReportText = "";
    private String progressText = "";
    private double progressValue = 0.0f;
    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
        notifyStateListeners(this);
    }
    public void appendtoReportText(String reportText){
        this.lastUpdateOnReportText = reportText;
        this.reportText+=reportText+"\n";
        notifyStateListeners(this);
    }

    public String getProgressText() {
        return progressText;
    }

    public void setProgressText(String progressText) {
        this.progressText = progressText;
        notifyStateListeners(this);
    }

    public String getLastUpdateOnReportText() {
        return lastUpdateOnReportText;
    }



    public double getProgressValue() {
        return progressValue;
    }

    public void setProgressValue(double progressValue) {
        this.progressValue = progressValue;
        notifyStateListeners(this);
    }
}
