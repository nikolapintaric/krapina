package THEGAME.module;

import THEGAME.DrawableEntity;
import THEGAME.EventData;
import org.lwjgl.Sys;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector4f;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by Kristijan on 8.1.2015..
 */
public class VehicleModule extends DrawableEntity {

    public static float moduleW, moduleH;

    public String type;
    public int w, h;
    public int posx, posy;

    public boolean selected;
    public Vector4f selectOverlay;

    // atributi
    public float mass, power;
    //public float heat, heatRate;

    public VehicleModule() {
        super();
        type = new String();
        w = h = 1;
        selectOverlay = new Vector4f(0.0f, 0.35f, 0.78f, 0.5f);
        selected = false;
    }


    public void checkSelected(Vector2f pos, EventData event) {
        //System.out.println("check " + type);
        float x0 = position.x + 100.0f;
        float y0 = position.y + 100.0f;
        if (x0 <= event.position.x && event.position.x < x0 + moduleW * w &&
                y0 <= event.position.y && event.position.y < y0 + moduleH * h) {
            selected = true;
        } else {
            selected = false;
        }
//        if (selected) System.out.println(type + " selected!");
    }

    @Override
    public void draw() {
        super.draw();
        if (selected) {
            glPushMatrix();
            glTranslatef(position.x, position.y, 0);

            glColor4f(selectOverlay.x, selectOverlay.y, selectOverlay.z, selectOverlay.w);

            glDisable(GL_TEXTURE_2D);

            glBegin(GL_TRIANGLE_FAN);
            glVertex2f(0.0f, 0.0f);
            glVertex2f(0.0f, size.y);
            glVertex2f(size.x, size.y);
            glVertex2f(size.x, 0.0f);
            glEnd();

            glPopMatrix();
        }
   }
}
