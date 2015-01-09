package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nikola on 08.01.15..
 */
public class Affector {
    protected Random random;
    public float randomMax = 0.1f;
    public Vector2f emitterPosition;
    public Vector2f position;


    public Affector(){
        random = new Random();
    }

    public Affector(Vector2f initPos, Vector2f position){
        emitterPosition = initPos;
        this.position = position;
    }

    protected float rand(){
        return (random.nextFloat() - 0.5f) * 2 * randomMax;
    }

    public void update(ArrayList<DrawableEntity> particles, float dt){

    }



}
