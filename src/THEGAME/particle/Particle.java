package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by nikola on 08.01.15..
 */
public class Particle extends DrawableEntity{
    public float decay;
    public boolean alive;

    public Particle(Vector2f pos, Vector3f color){
        this(pos, color, new Vector2f(0.0f, 0.0f));
    }
    public Particle(Vector2f pos, Vector3f color, Vector2f vel){
        super(pos, new Vector2f(0.0f, 0.0f), color, vel);
        System.out.println("new particle YEEEY!!!");
    }

    public void draw(){
        if(!alive) return;

        this.draw();
    }




}

