package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;

/**
 * Created by nikola on 09.01.15..
 */
public class AttractorAffector extends ForceAffector {
    public float force;

    public AttractorAffector(Vector2f pos, float force){
        super();
        this.position = pos;
        this.force = force;
    }

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity p:particles){
            Vector2f vel = new Vector2f((position.x - p.position.x),(position.y - p.position.y));
            float len = vel.lengthSquared();
            vel.normalise();
            vel.scale(dt * force / len * 2000000);

            Vector2f.add(p.velocity, vel, p.velocity);

        }

    }

}
