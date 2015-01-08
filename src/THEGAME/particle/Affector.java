package THEGAME.particle;

import THEGAME.DrawableEntity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nikola on 08.01.15..
 */
public class Affector {
    protected Random random;
    public float randomMax = 0.1f;


    public Affector(){
        random = new Random();

    }

    public void update(ArrayList<DrawableEntity> particles, float dt){

    }



}
