package TextFrecuencier.FrecuencierListener;

import TextFrecuencier.Frecuencier.Frecuencier;

public interface FrecuencierListener {
      void handleEvent(Frecuencier.Event event, Object origin);

}
