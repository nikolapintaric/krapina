package THEGAME.particle;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created by nikola on 09.01.15..
 */
public class AttractorAffector extends ForceAffector {

    public AttractorAffector(Vector2f pos, Vector2f emitterPos){
        super(pos);
        emitterPosition = emitterPos;
    }

}
