package KuroMoji;
import Api.TextFrecuencier;
import java.util.*;

public class IpadicFrecuencier implements TextFrecuencier<IpadicFrecuencyToken, IpadicToken> {


    private Map<IpadicToken,IpadicFrecuencyToken> tokenFrecuencyMap;

    public IpadicFrecuencier(){
        tokenFrecuencyMap = new HashMap<>();
    }


    private void AddTokenToMap(IpadicToken map){
        IpadicFrecuencyToken tokenfrecuency = this.tokenFrecuencyMap.get(map);
        if(Objects.isNull(tokenfrecuency)){
            this.tokenFrecuencyMap.put(map, new IpadicFrecuencyToken(map, 1));
        }else{
            this.tokenFrecuencyMap.put(map, new IpadicFrecuencyToken(map, tokenfrecuency.frecuency()+1));
        }
    }

    private List<IpadicFrecuencyToken> output(){
        List<IpadicFrecuencyToken> frecuencies = new ArrayList<>();
        this.tokenFrecuencyMap.forEach((kuroIpadicToken, kuroIpadicTokenFrecuency) -> frecuencies.add(kuroIpadicTokenFrecuency));
        return frecuencies;
    }

    @Override
    public List<IpadicFrecuencyToken> PerformFrecuency(List<IpadicToken> inputlist) {
        inputlist.parallelStream().forEach(this::AddTokenToMap);
        return output();
    }
}
