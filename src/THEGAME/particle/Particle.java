package THEGAME.particle;

import THEGAME.DrawableEntity;
import THEGAME.Helper;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

/**
 * Created by nikola on 08.01.15..
 */
public class Particle extends DrawableEntity{
    public float decay;
    public boolean alive;

    public Particle(Vector2f pos, Vector4f color){
        this(pos, color, new Vector2f(0.0f, 0.0f), true, 10);
    }
    public Particle(Vector2f pos, Vector4f color, Vector2f vel, boolean alive, float decay){
        super(pos, new Vector2f(0.0f, 0.0f), color, vel);
        this.alive = alive;
        this.decay = decay;
    }
    public Particle(boolean alive, float decay){
        this(new Vector2f(0.0f, 0.0f), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), new Vector2f(0.0f, 0.0f), alive, decay);
    }

    public void draw(){
        if(!alive) return;
        Helper.print(position);
        this.drawPoint();
    }




}

