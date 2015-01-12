package THEGAME;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Entity {

    public Vector2f position;
    public Vector2f size;

    public Entity() {
        position  = new Vector2f();
    }

    public void update(float dt){
    }

    public void draw(){
    }

    public void handleEvent(EventData event) {
        /*
        if (event.type == EventTypes.MOUSE_MOVED)
            mouseMoved(event.position.x, event.position.y);
        if (event.type == EventTypes.MOUSE_LEFT_PRESSED)
            mouseLeftPressed();
        if (event.type == EventTypes.MOUSE_LEFT_RELEASED)
            mouseLeftReleased();
        */
    }
}
