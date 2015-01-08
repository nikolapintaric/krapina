/**
 * Created by tonkosi on 08.01.15..
 */
public class TextureAsset extends Asset {

    public TextureAsset(String name, String path) {
        super(name);
        loadFromFile(path);
    }

    public boolean loadFromFile(String path) {
        return true;
    }

}
