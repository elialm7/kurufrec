package core;
import Api.TextFrecuencier;
import java.util.*;

public class KuroIpadicTextFrecuencier implements TextFrecuencier<KuroIpadicTokenFrecuency, KuroIpadicToken> {


    private Map<KuroIpadicToken,KuroIpadicTokenFrecuency> tokenFrecuencyMap;

    public KuroIpadicTextFrecuencier(){
        tokenFrecuencyMap = new HashMap<>();
    }


    private void AddTokenToMap(KuroIpadicToken map){
        KuroIpadicTokenFrecuency tokenfrecuency = this.tokenFrecuencyMap.get(map);
        if(Objects.isNull(tokenfrecuency)){
            this.tokenFrecuencyMap.put(map, new KuroIpadicTokenFrecuency(map, 1));
        }else{
            this.tokenFrecuencyMap.put(map, new KuroIpadicTokenFrecuency(map, tokenfrecuency.frecuency()+1));
        }
    }

    private List<KuroIpadicTokenFrecuency> output(){
        List<KuroIpadicTokenFrecuency> frecuencies = new ArrayList<>();
        this.tokenFrecuencyMap.forEach((kuroIpadicToken, kuroIpadicTokenFrecuency) -> frecuencies.add(kuroIpadicTokenFrecuency));
        return frecuencies;
    }

    @Override
    public List<KuroIpadicTokenFrecuency> PerformFrecuency(List<KuroIpadicToken> inputlist) {
        inputlist.parallelStream().forEach(this::AddTokenToMap);
        return output();
    }
}
