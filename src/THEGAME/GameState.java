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
    }

    public void init() {
        emitter = new Emitter(new Vector2f(Krapina.width / 2, Krapina.height / 2), 10);
    }

    public void update(float dt) {
        BackgroundClass.update(dt);
    }

    public void draw() {
        BackgroundClass.draw();
    }

}
