package THEGAME.module;

/**
 * Created by Kristijan on 8.1.2015..
 */
public class EngineModule extends VehicleModule {

    public float consumption;
    // consumption - fuel po sekundi
    // power - kolicina... necega... po jedinici iskoristenog fuela

    EngineModule() {
        super();
        type = "GenericEngine";
    }
}
