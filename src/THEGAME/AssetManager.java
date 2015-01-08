package THEGAME;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonkosi on 08.01.15..
 */
public class AssetManager {


    public static Map<String, Asset> mAssets;

    public AssetManager() {
        mAssets = new HashMap<String, Asset>();
    }

    public static void init() {
        mAssets = new HashMap<String, Asset>();
    }

    public static void addAsset(Asset asset) {
        mAssets.put(asset.name, asset);
    }

    public static Asset getAsset(String name) {
        return mAssets.get(name);
    }



}
