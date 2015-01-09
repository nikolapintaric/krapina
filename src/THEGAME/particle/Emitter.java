package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector4f;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nikola on 08.01.15..
 */
public class Emitter {
    private ArrayList<DrawableEntity> particles;
    private ArrayList<Affector> affectors;
    private int firstFree=0;
    public Vector2f position;
    public int maxParticles = 1000;
    public float milisecondSpeed;
    public float lastParticle;
    public Random random;

    public Emitter(Vector2f position, float milisecondSpeed){
        particles = new ArrayList<DrawableEntity>();
        affectors = new ArrayList<Affector>();
        this.position = position;
        position.y += 100;
        lastParticle = System.nanoTime() / 1000000.0f;
        this.milisecondSpeed = milisecondSpeed;
        System.out.println("Emitter constructed");
        random = new Random();
        for(int i=0; i<maxParticles; i++){
            particles.add(new Particle(false, 0));
        }
        addAffector(new TimeAffector());
        Vector2f normal = new Vector2f(0, 1);
        normal.normalise();
        addAffector(new BounceAffector(new Vector2f(position.x, 250), normal, 0.8f));
        addAffector(new ForceAffector(new Vector2f(0.0f, -9.81f)));
        addAffector(new PositionAffector());
       //addAffector(new ColorAffector(1.0f));
    }

    public void addParticle(Particle particle){

        particles.set(firstFree, particle);
        firstFree++;
        if(firstFree == maxParticles - 1)
            firstFree = 0;
    }

    public void addAffector(Affector affector){
        affectors.add(affector);
    }

    public void update(float dt){
        for(Affector a:affectors){
            a.update(particles, dt);
        }
        while(System.nanoTime() / 1000000.0f - lastParticle > milisecondSpeed){
            lastParticle = lastParticle + milisecondSpeed;
            addParticle(new Particle(new Vector2f(position), new Vector4f(1.0f, random.nextFloat(), 0.0f, 0.6f), new Vector2f((random.nextFloat() - 0.5f) * 3, random.nextFloat() * 10), true, 5.0f));
        }
    }

    public void draw(){
        for(DrawableEntity en:particles){
            en.draw();
        }
    }






}
