package TextFrecuencier.FrecuencierContext;
import java.util.List;
import TextFrecuencier.FrecuencyStrategy.FrecuencyStrategy;

public class Frecuencier<T>{
    private FrecuencyStrategy<T> strategy;
    public Frecuencier(){}
    public void setStrategy(FrecuencyStrategy<T> strategy){
        this.strategy = strategy;
    }
    public List<T> doFrecuency(){
        if(strategy == null) throw new NullPointerException("Strategy is not defined");
        return strategy.executeStrategy();
    }
}
