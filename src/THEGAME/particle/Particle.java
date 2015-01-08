package THEGAME.particle;

import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by nikola on 08.01.15..
 */
public class Particle {
    public Vector2f pos;
    public Vector2f vel;
    public Color color;
    public float decay;
    public boolean alive;


    public void draw(){
        if(!alive) return;

        //TODO add drawing and drawable entity

    }




}

