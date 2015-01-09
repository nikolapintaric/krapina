package THEGAME.gui;

import THEGAME.DrawableEntity;
import static org.lwjgl.opengl.GL11.*;

import THEGAME.EventData;
import THEGAME.EventTypes;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Container extends DrawableEntity {

    public String name;
    public Container parent;

    private ArrayList<Container> mChildren;

    public Vector2f absPosition;

    protected boolean hovered;

    public Container(String theName, Container theParent) {
        name = theName;
        parent = theParent;
        mChildren = new ArrayList<Container>();
        absPosition = new Vector2f(0, 0);
    }

    // TODO: napraviti funkciju koja ce imati vise opcija u konstruktoru

    public void addChild(Container child) {
        child.parent = this;
        mChildren.add(child);
    }

    public void draw() {
        glPushMatrix();
            glTranslatef(position.x, position.y, 0);


            glColor4f(1.f, 1.f, 1.f, 0.4f);
            if (hovered) glColor4f(1.f, 1.f, 0.4f, 0.5f);
            glDisable(GL_TEXTURE_2D);
            glBegin(GL_TRIANGLE_FAN);
                glVertex2f(0, 0);
                glVertex2f(size.x, 0);
                glVertex2f(size.x, size.y);
                glVertex2f(0, size.y);
            glEnd();

        for (Container child: mChildren) {
            child.draw();
        }

        glPopMatrix();
    }



    public void update(float dt) {

    }

    public void mouseMoved(float x, float y) {
        if (x >= position.x &&
                y >= position.y &&
                x < position.x + size.x &&
                y < position.y + size.y) {
            hovered = true;
        } else {
            hovered = false;
        }
        for (Container child: mChildren) {
            child.mouseMoved(x - position.x, y - position.y);
        }
    }

    public void handleEvent(EventData event) {
        if (event.type == EventTypes.MOUSE_MOVED)
            mouseMoved(event.position.x, event.position.y);
    }

}
