package THEGAME.particle;

import THEGAME.DrawableEntity;
import THEGAME.Helper;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.vector.Vector2f;

import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Created by nikola on 09.01.15..
 */
public class BounceAffector extends Affector {
    public Vector2f normal;
    public float bounceRatio;
    private Vector2f left;
    private Vector2f right;
    private Line2D line;
    public float width = 10f;

    public BounceAffector(Vector2f left, Vector2f rigth, float width, float bounceRatio){
        super();
        this.left = left;
        this.right = rigth;
        this.width = width;
        this.bounceRatio = bounceRatio;
        position = new Vector2f((left.x + rigth.x) / 2.0f, (left.y + rigth.y) / 2.0f);
        normal = Vector2f.sub(rigth, position, normal);

        Helper.rotateVector(normal, (float) (Math.PI / 2.0f));

        normal.normalise();
        line = new Line2D.Float(left.x, left.y, rigth.x, rigth.y);
    }

    private float height(Vector2f pos){
        return Vector2f.dot(new Vector2f(pos.x - position.x, pos.y - position.y), normal);
    }

    private void bounce(Vector2f velocity){
        float dot = (Vector2f.dot(velocity, normal));
        Vector2f y = new Vector2f(normal.x * Math.abs(dot) * bounceRatio + rand()*2, normal.y * Math.abs(dot) * bounceRatio + rand() * 10);
        Vector2f x = new Vector2f(rand(), rand());
        Vector2f.sub(velocity, new Vector2f(normal.x * dot, normal.y * dot), x);
        velocity.set(0, 0);
        Vector2f.add(x, y, velocity);
    }


    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity en:particles){

            if(line.intersectsLine(new Line2D.Float(en.position.x, en.position.y, en.position.x + en.velocity.x * dt * 1.5f, en.position.y + en.velocity.y * dt * 1.5f))){
                bounce(en.velocity);


            }
        }

    }

}
