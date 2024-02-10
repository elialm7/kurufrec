package View.ViewState;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StateListenable<T> {

    private  List<StateListener<T>> listeners = new ArrayList<>();

    public void addStateListener(StateListener<T> listener){
        if(listeners.contains(listener)) return;
        listeners.add(listener);
    }
    public void removeStateListener(StateListener<T> listener){
        if(!listeners.contains(listener)) return;
        listeners.remove(listener);
    }
    protected void notifyStateListeners(T tohandle){
        if(listeners.isEmpty())return;
        listeners.forEach(listener -> listener.handleStateChanged(tohandle));
    }

}
