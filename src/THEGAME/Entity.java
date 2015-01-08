package THEGAME;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Entity {

    public Vector2f position;
    protected Quad sprite;

    public Entity() {
        position  = new Vector2f();
    }

    public void update(float dt){

    }

    public void draw(){
        sprite.draw();
    }

}
