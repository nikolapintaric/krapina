package THEGAME.particle;

import THEGAME.DrawableEntity;
import THEGAME.Helper;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector4f;

import java.util.ArrayList;

/**
 * Created by nikola on 09.01.15..
 */
public class BounceAffector extends Affector {
    public Vector2f normal;
    public float bounceRatio;
    private Vector2f left;
    private Vector2f rigth;
    public float width = 10f;

    public BounceAffector(Vector2f left, Vector2f rigth, float width, float bounceRatio){
        this.left = left;
        this.rigth = rigth;
        this.width = width;
        this.bounceRatio = bounceRatio;
        position = new Vector2f((left.x + rigth.x) / 2.0f, (left.y + rigth.y) / 2.0f);
        normal = Vector2f.sub(rigth, position, normal);

        Helper.rotateVector(normal, (float) (Math.PI / 2.0f));

        normal.normalise();
        System.out.println("normal");
        Helper.print(normal);
    }

    private float height(Vector2f pos){
        return Vector2f.dot(new Vector2f(pos.x - position.x, pos.y - position.y), normal);
    }

    private void bounce(Vector2f velocity){
        float dot = (Vector2f.dot(velocity, normal));
        Vector2f y = new Vector2f(normal.x * Math.abs(dot) * bounceRatio + rand()*2, normal.y * Math.abs(dot) * bounceRatio + rand() * 10);
        Vector2f x = new Vector2f(0, 0);
        Vector2f.sub(velocity, new Vector2f(normal.x * dot, normal.y * dot), x);
        velocity.set(0, 0);
        Vector2f.add(x, y, velocity);
    }

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity en:particles){
            if(height(en.position)<=0 && height(en.position) > - 10 && en.position.x <= rigth.x && en.position.x >= left.x){
                bounce(en.velocity);

            }
        }

        glColor3f(1.0f, 0, 0);
        glBegin((GL_LINES));
        glVertex2f(left.x, left.y);
        glVertex2f(rigth.x, rigth.y);
        glEnd();
        glBegin((GL_LINES));
            glVertex2f(50, 50);
            glVertex2f(normal.x * 50 + 50, normal.y * 50 + 50);
        glEnd();
        glColor3f(1.0f, 1.0f, 1.0f);

        glPointSize(20);
        glBegin(GL_POINTS);
            glVertex2f(position.x, position.y);
        glEnd();
        glPointSize(1);


    }

}
