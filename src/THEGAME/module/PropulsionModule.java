package THEGAME.module;

import THEGAME.DrawableEntity;

/**
 * Created by Kristijan on 9.1.2015..
 */
public class PropulsionModule extends VehicleModule {

    public PropulsionModule() {
        super();
        type = "GenericPropulsion";
        this.setTexture("wood-wheel2", "res/wood_wheel2.png");
    }

    public void update(float dt){
        rotation -= 100 * dt;
    }

}
