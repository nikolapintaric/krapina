package THEGAME;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector4f;

/**
 * Created by nikola on 09.01.15..
 */
public class Helper {
    public static void print(Vector4f v){
        System.out.println(v.x + " " + v.y + " " + v.z + " " + v.w);
    }

    public static void print(Vector2f v){
        System.out.println(v.x + " " + v.y + " " );
    }
}
