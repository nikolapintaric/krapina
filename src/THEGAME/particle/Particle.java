package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by nikola on 08.01.15..
 */
public class Particle extends DrawableEntity{
    public float decay;
    public boolean alive;

    public Particle(Vector2f pos){
        super(pos);
    }

    public void draw(){
        if(!alive) return;

        this.draw();
    }




}

