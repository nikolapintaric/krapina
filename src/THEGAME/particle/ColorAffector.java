package THEGAME.particle;

import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;

/**
 * Created by nikola on 08.01.15..
 */
public class ColorAffector {
    public Vector3f colorMult;

    public void update(ArrayList<Particle> particles){
        for(Particle p:particles){
            p.color.set((int) (p.color.getRed() * colorMult.x),(int) (p.color.getGreen() * colorMult.y),(int) (p.color.getBlue() * colorMult.z));
        }
    }

}
