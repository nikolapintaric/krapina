package THEGAME.particle;

import THEGAME.DrawableEntity;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Container extends DrawableEntity {

    public String name;
    public Container parent;

    private ArrayList<Container> mChildren;

    public Vector2f absPosition;


    public Container(String theName, Container theParent) {
        name = theName;
        parent = theParent;
        mChildren = new ArrayList<Container>();
        absPosition = new Vector2f(0, 0);
    }

    // TODO: napraviti funkciju koja ce imati vise opcija u konstruktoru

    public void draw() {

    }

    public void update(float dt) {
        
    }



}
