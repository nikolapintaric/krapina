package THEGAME;

import java.util.HashMap;

/**
 * Created by Mihael on 1/9/2015.
 */
public class Section {
    private HashMap<String, String> data;
    public Section(){
        data = new HashMap<String, String>();
    }
    public void addPair(String key, String value){
        data.put(key, value);
    }
    public String getValue(String key){
        return data.get(key);
    }
    public HashMap<String, String> getValueMap(){
        return data;
    }
    public Boolean hasValue(String key){
        if(data.containsKey(key)) return true;
        return false;
    }
}
