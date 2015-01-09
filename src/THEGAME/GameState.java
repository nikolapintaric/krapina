package THEGAME;

import THEGAME.module.PropulsionModule;
import THEGAME.particle.Emitter;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by tonkosi on 07.01.15..
 */
public class GameState extends State {
    public Emitter emitter;
    public Vehicle vehicle;

    public GameState() {
        super("GameState");
        init();
    }

    public void init() {
        emitter = new Emitter(new Vector2f(Krapina.width / 2, Krapina.height / 2), 100);
        vehicle = new Vehicle();
        PropulsionModule tmp = new PropulsionModule();
        tmp.position.set(100.0f, 100.0f);
        tmp.size.set(100.0f, 100.0f);
        vehicle.addPart( 0, 0, tmp );
    }

    public void update(float dt) {
        BackgroundClass.update(dt);
        emitter.update(dt);
        vehicle.update(dt);
    }

    public void draw() {
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glPushMatrix();

        BackgroundClass.draw();
        emitter.draw();
        vehicle.draw();

        glPopMatrix();
    }

    public void handleEvent(EventData event) {
        System.out.println("EVENT DATA DOLAZI U GRAD: " + event.type);
    }

}
