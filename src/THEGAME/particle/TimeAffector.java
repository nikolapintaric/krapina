package THEGAME.particle;

import THEGAME.DrawableEntity;

import java.util.ArrayList;

/**
 * Created by nikola on 09.01.15..
 */
public class TimeAffector extends Affector {


    public TimeAffector(){
        super();
    }

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity en:particles){
            if(en instanceof Particle && ((Particle) en).alive){
                ((Particle) en).decay -= dt;
                if(((Particle) en).decay < 0.0f) {
                    ((Particle) en).alive = false;
                }
            }
        }

    }

}
