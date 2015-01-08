package THEGAME.particle;

import java.util.ArrayList;

/**
 * Created by nikola on 08.01.15..
 */
public class Emitter {
    private ArrayList<Particle> particles;
    private ArrayList<Affector> affectors;
    private int firstFree=0;


    public Emitter(){
        particles = new ArrayList<Particle>();
        affectors = new ArrayList<Affector>();

    }

    public void addParticle(Particle particle){
        if(particles.get(firstFree) == null)
            particles.add(particle);
        else
            particles.set(firstFree, particle);
    }

    public void addAffector(Affector affector){
        affectors.add(affector);
    }

    public void update(){
        for(Affector a:affectors){
            a.update(particles);
        }
    }






}
