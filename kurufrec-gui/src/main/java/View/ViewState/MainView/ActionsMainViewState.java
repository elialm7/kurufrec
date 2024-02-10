package View.ViewState.MainView;

import View.ViewState.StateListenable;
import View.ViewState.StateListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ActionsMainViewState extends StateListenable<ActionsMainViewState> {

    private List<StateListener<ActionsMainViewState>> handlers = new ArrayList<>();

    private File selectedFile;
    private boolean isFrecuencyActionRunning = false;

    public void setSelectedFile(File file){
        this.selectedFile = file;
        notifyStateListeners(this);
    }
    public void setFrecuencyActionRunning(boolean running){
        this.isFrecuencyActionRunning = running;
        notifyStateListeners(this);
    }
    public boolean isFrecuencyActionRunning(){
        return this.isFrecuencyActionRunning;
    }
    public File getSelectedFile(){
        return this.selectedFile;
    }

}
