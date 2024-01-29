package TextFrecuencier.Frecuencier;

import TextFrecuencier.FrecuencierListener.FrecuencierListener;

import java.util.ArrayList;
import java.util.List;


public abstract class Frecuencier<T>{


    public enum Event{
        PREPARING,READY,EXECUTING,FAILED,FINISHING, FINISHED
    }

    private List<FrecuencierListener> listeners = new ArrayList<>();
    private Event evt;
    private int min = 0;
    private int current = 0;
    private int max = 0;
    public  void  addListener(FrecuencierListener observer){
        if(listeners.contains(observer))return;
        this.listeners.add(observer);
    }
    public void removeListener(FrecuencierListener observer){
        if(!listeners.contains(observer))return;
        listeners.remove(observer);
    }

    protected void emitEvent(Event evt, Object origin){
        this.evt = evt;
        if(listeners.isEmpty()) return;
        listeners.forEach(frecuencierListener -> frecuencierListener.handleEvent(evt, origin));
    }
    protected void setCurrent(int current){
        this.current = current;
    }
    protected void setMax(int max){
        this.max = max;
    }
    protected void setMin(int min){
        this.min = min;
    }

    public int getMin() {
        return min;
    }

    public int getCurrent() {
        return current;
    }

    public int getMax() {
        return max;
    }

    public abstract T execute();

}
