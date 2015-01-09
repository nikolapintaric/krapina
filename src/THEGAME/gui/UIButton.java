package THEGAME.gui;

import THEGAME.AssetManager;
//import sun.font.TrueTypeFont;
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
    }

    public void draw() {
        glPushMatrix();
            glTranslatef(position.x, position.y, 0);

            glDisable(GL_TEXTURE_2D);
            glColor4f(1.0f, 0, 0.6f, 0.5f);
            if (hovered) glColor4f(1.0f, 0.5f, 0.6f, 0.5f);

            TrueTypeFont gg = AssetManager.getFont("arial");



            glBegin(GL_QUADS);
                glVertex2f(0, 0);
                glVertex2f(size.x, 0);
                glVertex2f(size.x, size.y);
                glVertex2f(0, size.y);
            glEnd();

            glPushMatrix();
                String str = "yabay";
                int w = gg.getHeight(str);
                glTranslatef(0, w, 0);
                glScalef(1.f,-1.f,0);
                glEnable(GL_TEXTURE_2D);
                gg.drawString(0, 0, str, Color.yellow);
            glPopMatrix();

        glPopMatrix();
    }

    public void mouseLeftPressed() {
        super.mouseLeftPressed();
    }

}
