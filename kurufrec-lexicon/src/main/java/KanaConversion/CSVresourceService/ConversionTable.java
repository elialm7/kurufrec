package KanaConversion.CSVresourceService;

import java.util.Map;

public class ConversionTable {

    private Map<String, String> table;
    private int maxlengt;


    public ConversionTable(Map<String, String> table){
        this.table = table;
        setMaxlengt();
    }

    private void setMaxlengt(){
        for(String key :table.keySet()){
            if(key.length() > maxlengt){
                maxlengt = key.length();
            }
        }

    }

    public int getMaxlengt(){
        return maxlengt;
    }

    public String valueof(String key){
        return table.get(key);
    }
}
