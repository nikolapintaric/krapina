package THEGAME.gui;

import THEGAME.AssetManager;
//import sun.font.TrueTypeFont;
import THEGAME.StateManager;
import THEGAME.module.Utils;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.TrueTypeFont;


import java.awt.*;

import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.Color;

/**
 * Created by tonkosi on 09.01.15..
 */
public class UIButton extends Container {

    public UIButton(String name) {
        super(name, null);
        size.set(150, 30);
    }

    public void draw() {
        glPushMatrix();
            glTranslatef(position.x, position.y, 0);

            glDisable(GL_TEXTURE_2D);
            glColor4f(1.0f, 0, 0.6f, 0.5f);
            if (hovered) glColor4f(1.0f, 0.5f, 0.6f, 0.5f);

            TrueTypeFont gg = AssetManager.getFont("arial");



            glColor4f(1.0f, 1.0f, 1.0f, 1.0f);


            glBegin(GL_LINES);
                glVertex2f(0, 0);
                glVertex2f(size.x, 0);
                glVertex2f(size.x, 0);
                glVertex2f(size.x, size.y);
                glVertex2f(size.x, size.y);
                glVertex2f(0, size.y);
                glVertex2f(0, size.y);
                glVertex2f(0, 0);
            glEnd();


            Vector2f sz = Utils.getTextSize("New Game", "arial", 14);
            glPushMatrix();
                glTranslatef((int)((size.x - sz.x)/2), (int)((size.y - sz.y)/2), 0);
                Utils.drawText("New Game", "arial", 14);

            glPopMatrix();
    /*

            Vector2f sz = Utils.textSize("New Game", "arial", 14);
            Utils.drawText("New Game", "arial", 14);

            glPushMatrix();
                String str = "New Game";
                int w = gg.getHeight(str);
                glTranslatef(0, w, 0);
                glScalef(1.f,-1.f,0);
                glEnable(GL_TEXTURE_2D);
                gg.drawString(0, 0, str, Color.yellow);
            glPopMatrix();*/

        glPopMatrix();
    }

    public void mouseLeftPressed() {
        super.mouseLeftPressed();
        if (pressed) StateManager.changeState("GameState");
    }

    public void mouseLeftReleased() {
        super.mouseLeftReleased();
    }

}
