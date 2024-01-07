package TextFrecuencier.FrecuencyStrategy;

import TextFrecuencier.FrecuencyObservers.FrecuencyObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class FrecuencyStrategy<T>{


    public enum State{
        PREPARING,READY,EXECUTING,FAILED,FINISHING, FINISHED
    }

    private List<FrecuencyObserver> observers = new ArrayList<>();
    private State state;
    public void addObserver(FrecuencyObserver observer){
        if(observers.contains(observer))return;
        this.observers.add(observer);
    }

    public void removeObserver(FrecuencyObserver observer){
        if(!observers.contains(observer))return;
        observers.remove(observer);
    }
    public void updateProgress(int current, int max){
        if(observers.isEmpty()) return;
        observers.forEach(obs -> obs.updateProgress(current, max));
    }

    public void updateMessage(String message){
        if(observers.isEmpty()) return;
        observers.forEach(obs -> obs.updateMessage(state, message));
    }

    public void setChangedState(FrecuencyStrategy.State state){
        this.state = state;
    }

    public abstract List<T> executeStrategy();

}
