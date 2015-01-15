package THEGAME.particle;

import THEGAME.DrawableEntity;
import static org.lwjgl.opengl.GL11.*;
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
    public int maxParticles = 100;
    public float milisecondSpeed;
    public float lastParticle;
    public Random random;

    public Emitter(Vector2f position, float milisecondSpeed){
        particles = new ArrayList<DrawableEntity>();
        affectors = new ArrayList<Affector>();
        this.position = position;
        position.y += 100;
        lastParticle = 0.0f;
        this.milisecondSpeed = milisecondSpeed;
        System.out.println("Emitter constructed");
        random = new Random();
        for(int i=0; i<maxParticles; i++){
            particles.add(new Particle(false, 0));
        }
        addAffector(new TimeAffector());
        Vector2f normal = new Vector2f(0, 1);
        normal.normalise();
        addRectBounce(new Vector2f(100, 150), new Vector2f(250, 100), 0.4f);
        addAffector(new ForceAffector(new Vector2f(0.0f, -9.81f*30)));
        addAffector(new PositionAffector());
        //addAffector(new AttractorAffector(new Vector2f(225, 400), 10f));
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
        lastParticle += dt * 1000;
        while(lastParticle > milisecondSpeed){
            lastParticle -= milisecondSpeed;
            addParticle(new Particle(new Vector2f(600, 350), new Vector4f(1.0f, random.nextFloat(), 0.0f, 0.6f), new Vector2f((random.nextFloat() - 0.5f) * 120 - 300f, random.nextFloat() * 180), true, 50));
        }
    }

    public void draw(){
        glPushMatrix();
        glTranslatef(this.position.x, this.position.y, 0.0f);
        for(DrawableEntity en:particles){
            en.draw();
        }
        glPopMatrix();
    }

    public void addRectBounce(Vector2f bottomLeft, Vector2f size, float bounceRatio){
        addAffector(new BounceAffector(bottomLeft, new Vector2f(bottomLeft.x, bottomLeft.y + size.y), bounceRatio));
        addAffector(new BounceAffector(new Vector2f(bottomLeft.x, bottomLeft.y + size.y), new Vector2f(bottomLeft.x + size.x, bottomLeft.y + size.y), bounceRatio));
        addAffector(new BounceAffector(new Vector2f(bottomLeft.x + size.x, bottomLeft.y + size.y), new Vector2f(bottomLeft.x + size.x, bottomLeft.y), bounceRatio));
        addAffector(new BounceAffector(new Vector2f(bottomLeft.x + size.x, bottomLeft.y), bottomLeft, bounceRatio));


    }






}
