package THEGAME;

/**
 * Created by tonkosi on 07.01.15..
 */
public class GameState extends State {

    public GameState() {
        super("GameState");
    }

    public void init() {

    }

    public void update(double dt) {
        BackgroundClass.update(dt);
    }

    public void draw() {
        BackgroundClass.draw();
    }

}
