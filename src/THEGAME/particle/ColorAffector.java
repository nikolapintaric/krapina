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
            p.color.set((int) (p.color.x * colorMult.x * random.nextFloat() * randomMax)
                    , (int) (p.color.y * colorMult.y * random.nextFloat() * randomMax)
                    , (int) (p.color.z * colorMult.z * random.nextFloat() * randomMax));
    }

}
