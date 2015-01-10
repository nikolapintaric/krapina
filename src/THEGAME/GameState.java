package THEGAME;

import THEGAME.module.ModuleEnum;
import THEGAME.module.ModuleFactory;
import THEGAME.module.PropulsionModule;
import THEGAME.module.VehicleModule;
import THEGAME.particle.Emitter;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created by tonkosi on 07.01.15..
 */
public class GameState extends State {
    public Emitter emitter;
    public Vehicle vehicle;
    public Background background;

    public GameState() {
        super("GameState");
        init();
    }

    public void init() {
        emitter = new Emitter(new Vector2f(Krapina.width / 2, Krapina.height / 2), 5);
        vehicle = new Vehicle();
        background = new Background();

        PropulsionModule.moduleH = 50;
        PropulsionModule.moduleW = 50;

        VehicleModule tmp;
        tmp = ModuleFactory.createModule(ModuleEnum.PROPULSIONMODULE, 0, 0);
        vehicle.addModule(tmp);
        tmp = ModuleFactory.createModule(ModuleEnum.PROPULSIONMODULE, 2, 0);
        vehicle.addModule(tmp);
        tmp = ModuleFactory.createModule(ModuleEnum.PROPULSIONMODULE, 4, 0);
        vehicle.addModule(tmp);
        
        tmp = ModuleFactory.createModule(ModuleEnum.FRAMEMODULE, 0, 1);
        vehicle.addModule(tmp);
        tmp = ModuleFactory.createModule(ModuleEnum.FRAMEMODULE, 1, 1);
        vehicle.addModule(tmp);
        tmp = ModuleFactory.createModule(ModuleEnum.FRAMEMODULE, 2, 1);
        vehicle.addModule(tmp);
        tmp = ModuleFactory.createModule(ModuleEnum.FRAMEMODULE, 3, 1);
        vehicle.addModule(tmp);
        tmp = ModuleFactory.createModule(ModuleEnum.FRAMEMODULE, 4, 1);
        vehicle.addModule(tmp);
        
        tmp = ModuleFactory.createModule(ModuleEnum.FRAMEMODULE, 0, 2);
        vehicle.addModule(tmp);
        tmp = ModuleFactory.createModule(ModuleEnum.FRAMEMODULE, 4, 2);
        vehicle.addModule(tmp);
        
        tmp = ModuleFactory.createModule(ModuleEnum.ENGINEMODULE, 1, 2);
        vehicle.addModule(tmp);
        tmp = ModuleFactory.createModule(ModuleEnum.FUELMODULE, 3, 2);
        vehicle.addModule(tmp);

        System.out.println("GameState Init complete");
    }

    public void update(float dt) {
        background.update(dt);
        emitter.update(dt);
        vehicle.update(dt);

        background.position.set(vehicle.position);
        emitter.position.set(vehicle.position);
    }

    public void draw() {
        glMatrixMode(GL_PROJECTION);
        glTranslated(-vehicle.position.x, -vehicle.position.y, 0.0f);

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glPushMatrix();

        background.draw();
        emitter.draw();
        vehicle.draw();

        glPopMatrix();
    }

    public void handleEvent(EventData event) {
        System.out.println("EVENT DATA DOLAZI U GRAD: " + event.type);
        if (event.type == 1) {
            System.out.println(event.position.x + " " + event.position.y);
            vehicle.onMouseMove(event);
        }
    }

}
