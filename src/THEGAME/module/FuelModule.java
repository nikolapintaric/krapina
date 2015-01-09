package THEGAME.module;

/**
 * Created by Kristijan on 8.1.2015..
 */
public class FuelModule extends VehicleModule {

    public float capacity, used;

    public FuelModule() {
        super();
        type = "GenericFuelTank";
        this.setTexture("steel-tank", "res/steel_tank.png");
    }

    public void draw() {
        draw_quad();
    }
}
