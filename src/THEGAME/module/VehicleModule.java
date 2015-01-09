package THEGAME.module;

import THEGAME.DrawableEntity;

/**
 * Created by Kristijan on 8.1.2015..
 */
public class VehicleModule extends DrawableEntity {

    public static float moduleW, moduleH;

    public String type;
    public int w, h;
    public int posx, posy;

    // atributi
    public float mass, power;
    //public float heat, heatRate;

    public VehicleModule() {
        super();
        type = new String();
    }


}
