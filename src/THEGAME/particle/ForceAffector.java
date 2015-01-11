package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nikola on 08.01.15..
 */
public class ForceAffector extends Affector {
    public Vector2f force;



    public ForceAffector(Vector2f force){
        this();
        this.force = force;
    }

    public ForceAffector(){
        super();
    }


    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity en:particles){
            Vector2f.add(en.velocity, new Vector2f(force.x * dt, force.y * dt), en.velocity);
        }

    }

}
