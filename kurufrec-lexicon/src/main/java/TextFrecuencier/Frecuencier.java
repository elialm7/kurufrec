package TextFrecuencier;

import TextFrecuencier.FrecuencyObservers.FrecuencyObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Frecuencier<T>{


    private List<FrecuencyObserver> observers = new ArrayList<>();


    public void addObserver(FrecuencyObserver observer){
        if(observers.contains(observer))return;
        this.observers.add(observer);
    }

    public void removeObserver(FrecuencyObserver observer){
        if(!observers.contains(observer))return;
        observers.remove(observer);
    }


    public void callupdate(String currentState, String lastState){
        for(FrecuencyObserver obs: observers){
            obs.update(currentState, lastState);
        }
    }

    public abstract List<T> doFrecuency();

}
