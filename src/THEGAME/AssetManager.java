package THEGAME;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;


/**
 * Created by tonkosi on 08.01.15..
 */
public class AssetManager {


    public static Map<String, Texture> mTextures;
    //public static Map<String, Asset> mSounds;


    public static void init() {
        mTextures = new HashMap<String, Texture>();
        // TODO: mSounds   = new HashMap<String, Asset>();
    }

    private static boolean existsTexture(String name) {
        Texture tmp = mTextures.get(name);
        if (tmp == null) return false;
        return true;
    }

    public static void addTexture(String name, String path) {
        if (!existsTexture(name)) {
            mTextures.put(name, loadTexture(path));
        }
    }

    public static Texture loadTexture(String path) {
        try {
            Texture ret = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
            return ret;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void useTexture(String name) {
        if (!existsTexture(name)) {
            System.err.println("AssetManaget.useTexture(): ne postoji id pod " + name);
            return;
        }
        glBindTexture(GL_TEXTURE_2D, mTextures.get(name).getTextureID());
    }



}
