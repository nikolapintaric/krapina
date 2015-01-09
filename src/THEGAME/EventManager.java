package THEGAME;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

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
                event.position = new Vector2f(Mouse.getEventX(), Mouse.getEventY());
                return true;
            }
        }

        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                event.type = EventTypes.KEY_PRESSED;
                event.keyCode = Keyboard.getEventKey();
                return true;
            } else {
                event.type = EventTypes.KEY_RELEASED;
                event.keyCode = Keyboard.getEventKey();
                return true;
            }
        }
        return false;
    }

}
