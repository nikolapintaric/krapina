package THEGAME;

import THEGAME.particle.Emitter;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by tonkosi on 07.01.15..
 */
public class GameState extends State {
    public Emitter emitter;

    public GameState() {
        super("GameState");
        init();
    }

    public void init() {
        emitter = new Emitter(new Vector2f(Krapina.width / 2, Krapina.height / 2), 100);
    }

    public void update(float dt) {
        BackgroundClass.update(dt);
        emitter.update(dt);
    }

    public void draw() {
        BackgroundClass.draw();
        emitter.draw();
    }

    public void handleEvent(EventData event) {
        System.out.println("EVENT DATA DOLAZI U GRAD: " + event.type);
    }

}
