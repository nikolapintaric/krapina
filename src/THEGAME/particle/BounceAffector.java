package THEGAME.particle;

import THEGAME.DrawableEntity;
import THEGAME.Helper;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector4f;

import java.util.ArrayList;

/**
 * Created by nikola on 09.01.15..
 */
public class BounceAffector extends Affector {
    public Vector2f normal;
    public float bounceRatio;
    private Vector2f leftPos;
    private Vector2f rigthPos;

    public BounceAffector(Vector2f position, Vector2f normal, float bounceRatio){
        this.position = position;
        this.normal = normal;
        this.bounceRatio = bounceRatio;
    }

    private boolean collide(Vector2f pos){
        return Vector2f.dot(new Vector2f(pos.x - position.x, pos.y - position.y), normal) <= 0;
    }

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity en:particles){
            if(collide(en.position)){
                float dot = (Vector2f.dot(en.velocity, normal));
                Vector2f y = new Vector2f(normal.x * Math.abs(dot) * bounceRatio + rand()*2, normal.y * Math.abs(dot) * bounceRatio + rand() * 10);
                Vector2f x = new Vector2f(rand(), rand());
                Vector2f.sub(en.velocity, new Vector2f(normal.x * dot, normal.y * dot), x);
                en.velocity = new Vector2f(0, 0);
                Vector2f.add(x, y, en.velocity);
                //Helper.print(x);
            }
        }

    }

}
