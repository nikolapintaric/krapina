package THEGAME.module;

/**
 * Created by Kristijan on 8.1.2015..
 */
public class FuelModule extends VehicleModule {

    public float capacity, used;

    FuelModule() {
        super();
        type = "GenericFuelTank";
    }
}
