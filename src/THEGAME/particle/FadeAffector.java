package THEGAME.particle;

import THEGAME.DrawableEntity;
import THEGAME.Helper;

import java.util.ArrayList;

/**
 * Created by nikola on 09.01.15..
 */
public class FadeAffector extends Affector {
    public float speed;

    public FadeAffector(float speed){
        super();
        this.speed = speed;
    }

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity en:particles){
            en.color.w -= speed*dt;
        }
    }
}
