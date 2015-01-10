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

    public static void rotateVector(Vector2f vec, float angle){
        float length = vec.length();
        vec.normalise();
        angle = angle + (float) Math.asin(vec.y);
        vec.set(0, 0);
        vec.set((float) Math.cos((double) angle), (float) Math.sin((double) angle));
        vec.scale(length);
    }
}
