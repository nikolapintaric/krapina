package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;

/**
 * Created by nikola on 08.01.15..
 */
public class ForceAffector extends Affector {
    public Vector2f force;
    public Vector2f initalPosition;

    public ForceAffector(Vector2f position){
        force = new Vector2f(0, 9.81f / 3);
        initalPosition = position;
    }

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity en:particles){
            Vector2f.add(en.velocity, new Vector2f((initalPosition.x - en.position.x) * 0.003f , force.y * dt), en.velocity);
        }

    }

}
