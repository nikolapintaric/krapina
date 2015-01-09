package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;

/**
 * Created by nikola on 08.01.15..
 */
public class PositionAffector extends Affector{

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity p:particles){
            Vector2f.add(p.position, p.velocity, p.position);
        }
    }
}
