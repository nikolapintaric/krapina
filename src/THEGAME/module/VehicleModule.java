package THEGAME.module;

import THEGAME.DrawableEntity;
import THEGAME.EventData;

/**
 * Created by Kristijan on 8.1.2015..
 */
public class VehicleModule extends DrawableEntity {

    public static float moduleW, moduleH;

    public String type;
    public int w, h;
    public int posx, posy;

    public boolean selected;

    // atributi
    public float mass, power;
    //public float heat, heatRate;

    public VehicleModule() {
        super();
        type = new String();
        w = h = 1;
    }

    /*
    public void checkSelected(EventData event) {
        int x0 = posx * moduleW;
        int y0 = posy * moduleH;
        if (x0 <= event.position.x && event.position.x <= x0 + moduleW * w &&
                y0 <= event.position.y && event.position.y <= y0 + moduleH * h) {
            selected = true;
        } else {
            selected = false;
        }
    }*/
}
