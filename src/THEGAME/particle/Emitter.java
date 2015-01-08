package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;

/**
 * Created by nikola on 08.01.15..
 */
public class Emitter {
    private ArrayList<DrawableEntity> particles;
    private ArrayList<Affector> affectors;
    private int firstFree=0;
    public Vector2f pos;
    public int maxParticles = 100;
    public float milisecondSpeed;
    public float lastParticle;

    public Emitter(Vector2f pos, float milisecondSpeed){
        particles = new ArrayList<DrawableEntity>();
        affectors = new ArrayList<Affector>();
        this.pos = pos;
        lastParticle = System.nanoTime() / 1000000.0f;
        this.milisecondSpeed = milisecondSpeed;
        System.out.println("Emitter constructed");
    }

    public void addParticle(Particle particle){
/*        particles.set(firstFree, particle);
        firstFree++;
        if(firstFree == maxParticles - 1)
            firstFree = 0;
*/
    }

    public void addAffector(Affector affector){
        affectors.add(affector);
    }

    public void update(float dt){
        System.out.println("update");
        for(Affector a:affectors){
            a.update(particles, dt);
        }
        if(System.nanoTime() / 1000000.0f - lastParticle > milisecondSpeed){
            lastParticle = System.nanoTime() / 1000000.0f;
            addParticle(new Particle(pos, new Vector3f(1.0f, 0.0f, 0.0f)));
        }
    }

    public void draw(){
        for(DrawableEntity en:particles){
            en.drawPoint();
        }
    }






}
