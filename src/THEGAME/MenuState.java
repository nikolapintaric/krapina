package THEGAME;

import THEGAME.gui.Container;
import THEGAME.gui.UIButton;

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
        cont.size.set(400, 200);
        cont.position.set(200, 200);


        Container haha = new UIButton("rr");
        cont.addChild(haha);
        haha.position.set(125, 100);

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
