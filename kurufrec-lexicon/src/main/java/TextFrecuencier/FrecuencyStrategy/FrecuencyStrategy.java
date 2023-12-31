package TextFrecuencier.FrecuencyStrategy;

import TextFrecuencier.FrecuencyObservers.FrecuencyObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class FrecuencyStrategy<T>{


    public enum State{
        PREPARING,READY,EXECUTING,FAILED,FINISHING, FINISHED
    }

    private List<FrecuencyObserver> observers = new ArrayList<>();


    public void addObserver(FrecuencyObserver observer){
        if(observers.contains(observer))return;
        this.observers.add(observer);
    }

    public void removeObserver(FrecuencyObserver observer){
        if(!observers.contains(observer))return;
        observers.remove(observer);
    }

    public void notifyObservers(FrecuencyStrategy.State state, String message){
        if(observers.isEmpty()) return;
        observers.forEach(obs -> obs.update(state, message));
    }

    public abstract List<T> executeStrategy();

}
