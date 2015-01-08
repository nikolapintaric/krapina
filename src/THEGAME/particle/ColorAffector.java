package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;

/**
 * Created by nikola on 08.01.15..
 */
public class ColorAffector extends Affector{
    public Vector3f colorMult;


    public  ColorAffector(){
        super();
        colorMult = new Vector3f();

    }

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity p:particles)
            p.color.set((int) (p.color.getRed() * colorMult.x * random.nextFloat() * randomMax)
                    , (int) (p.color.getGreen() * colorMult.y * random.nextFloat() * randomMax)
                    , (int) (p.color.getBlue() * colorMult.z * random.nextFloat() * randomMax));
    }

}
