package THEGAME;

import THEGAME.gui.Container;

/**
 * Created by tonkosi on 07.01.15..
 */
public class MenuState extends State {

    Container cont;

    public MenuState() {
        super("MenuState");
        init();
    }


    public void init() {
        cont = new Container("root", null);
        cont.size.set(300, 200);
        cont.position.set(100, 100);

        Container haha = new Container("rr", null);
        cont.addChild(haha);
        haha.size.set(100,60);
        haha.position.set(20, 60);

    }

    public void update(float dt) {

    }

    public void draw() {
        cont.draw();
    }

    public void handleEvent(EventData event) {
        cont.handleEvent(event);
    }

}
