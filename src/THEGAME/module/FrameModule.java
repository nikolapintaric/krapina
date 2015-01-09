package THEGAME.module;

/**
 * Created by Kristijan on 8.1.2015..
 */
public class FrameModule extends VehicleModule {

    //public float durability;

    FrameModule() {
        super();
        type = "GenericFrame";
        this.setTexture("wood-frame", "res/wood_frame.png");
    }
}
