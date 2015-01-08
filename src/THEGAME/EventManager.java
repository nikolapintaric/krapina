package THEGAME;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.awt.*;

/**
 * Created by tonkosi on 08.01.15..
 */
public class EventManager {

    public static void init() {

    }

    public static boolean pollEvent(EventData event) {
        while (Mouse.next()) {
            // clicks
            if (Mouse.getEventButtonState()) {
                if (Mouse.getEventButton() == 0) {
                    event.type = EventTypes.MOUSE_LEFT_PRESSED;
                    return true;
                }
            } else {
                if (Mouse.getEventButton() == 0) {
                    event.type = EventTypes.MOUSE_LEFT_RELEASED;
                    return true;
                }
            }
            // mouse move
            if (Mouse.getEventDX() == 0 || Mouse.getEventDY() == 0) {
                event.type = EventTypes.MOUSE_MOVED;
                event.x = Mouse.getEventX();
                event.y = Mouse.getEventY();
                return true;
            }
        }

        while (Keyboard.next()) {

        }
        return false;
    }

}
