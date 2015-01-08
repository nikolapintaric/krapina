package THEGAME.module;

import THEGAME.DrawableEntity;

/**
 * Created by Kristijan on 9.1.2015..
 */
public class PropulsionModule extends VehicleModule {

    PropulsionModule() {
        super();
        type = "GenericPropulsion";
        this.setTexture("wood-wheel", "res/wood_wheel.png");
    }

    public void update(float dt){
        rotation += 10 * dt;
    }
}
