package THEGAME.module;

import THEGAME.EventData;
import THEGAME.EventTypes;

import javax.swing.event.DocumentEvent;

/**
 * Created by Kristijan on 8.1.2015..
 */
public class EngineModule extends VehicleModule {

    public float consumption;
    public float fuel;
    public float speed;
    // consumption - fuel po sekundi
    // power - kolicina... necega... po jedinici iskoristenog fuela

    public EngineModule() {
        super();
        type = "GenericEngine";
        w = 2;
        h = 1;
        this.setTexture("engine", "res/engine.png");
        speed = 0.0f;
        fuel = 0.0f;
        consumption = 10.0f;
    }

    public void update(float dt){
        speed *= 0.98f;
        if(fuel>consumption){
            fuel -= consumption;
            speed += 20.0f;
        }
        System.out.println(speed);
    }

    public void handleEvent(EventData event){
        if(event.type == EventTypes.MOUSE_LEFT_RELEASED){
            fuel += 100.0f;
        }
    }


}
