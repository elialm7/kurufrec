package UIStateModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainViewStateModel {
    private List<MainViewStateModelListener> listeners = new ArrayList<>();
    private Boolean onOpeningAfter = false;
    private Boolean onFiltering = false;
    private String logAreatext = "";
    private String progresslabel = "";
    private File selectedfile;
    private void notifyListeners(){
        if(listeners.isEmpty())return;
        listeners.forEach(listener -> listener.onMainViewStateChanged(this));
    }
    public void addlistener(MainViewStateModelListener listener){
        this.listeners.add(listener);
    }
    public Boolean getOnOpeningAfter() {
        return onOpeningAfter;
    }
    public void setOnOpeningAfter(Boolean onOpeningAfter) {
        this.onOpeningAfter = onOpeningAfter;
        notifyListeners();
    }
    public Boolean getOnFiltering() {
        return onFiltering;
    }
    public void setOnFiltering(Boolean onFiltering) {
        this.onFiltering = onFiltering;
        notifyListeners();
    }
    public String getLogAreatext() {
        return logAreatext;
    }
    public void setLogAreatext(String logAreatext) {
        this.logAreatext = logAreatext;
        notifyListeners();
    }
    public void appendlogAreaText(String append){
        StringBuilder builder = new StringBuilder(this.logAreatext);
        builder.append(append+"\n");
        this.logAreatext = builder.toString();
        notifyListeners();
    }
    public String getProgresslabel() {
        return progresslabel;
    }
    public void setProgresslabel(String progresslabel) {
        this.progresslabel = progresslabel;
        notifyListeners();
    }
    public void setSelectedfile(File file){
        this.selectedfile = file;
        notifyListeners();
    }
    public File getSelectedfile(){
        return this.selectedfile;
    }
}
