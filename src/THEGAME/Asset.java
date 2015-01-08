package THEGAME;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Asset {

    public String name; // or maybe ID?

    public Asset(String theName) {
        name = theName;
    }

    public boolean loadFromFile(String path) {
        return false;
    }

}
