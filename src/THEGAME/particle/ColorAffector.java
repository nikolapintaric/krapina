package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

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

    public ColorAffector(float randMax){
        this();
        this.randomMax = randMax;
    }

    public void update(ArrayList<DrawableEntity> particles, float dt){
        for(DrawableEntity p:particles) {

        }
    }

}