package THEGAME.module;

import THEGAME.manager.AssetManager;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

/**
 * Created by tonkosi on 09.01.15..
 */
public class Utils {

    public static void drawText(String str, String fontName, int fontSize) {
        TrueTypeFont font = AssetManager.getFont(fontName);
        int height = font.getHeight(str);
        glPushMatrix();

            glTranslatef(0, height, 0);
            glScalef(1.0f, -1.0f, 0.0f);
            glEnable(GL_TEXTURE_2D);

            font.drawString(0, 0, str, Color.white);
        glPopMatrix();
    }

    public static Vector2f getTextSize(String str, String fontName, int fontSize) {
        TrueTypeFont font = AssetManager.getFont(fontName);
        return new Vector2f(font.getWidth(str), font.getHeight(str));
    }


}
