package TextFrecuencier.FrecuencyObservers;

import TextFrecuencier.FrecuencyStrategy.FrecuencyStrategy;

public interface FrecuencyObserver {

    void update(FrecuencyStrategy.State state, String message);


}
