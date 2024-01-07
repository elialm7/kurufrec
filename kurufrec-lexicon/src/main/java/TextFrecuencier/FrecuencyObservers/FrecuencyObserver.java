package TextFrecuencier.FrecuencyObservers;

import TextFrecuencier.FrecuencyStrategy.FrecuencyStrategy;

public interface FrecuencyObserver {

    void updateMessage(FrecuencyStrategy.State state, String message);
    void updateProgress(int currentProgress, int maxProress);

}
