package THEGAME.manager;

import THEGAME.EventData;
import THEGAME.EventTypes;
import THEGAME.Krapina;
import javafx.scene.Camera;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

/**
 * Created by tonkosi on 08.01.15..
 */
public class EventManager {

    private static int lastX = -1;
    private static int lastY = -1;
    private static boolean correctForCamera = false;

    public static void init() {

    }

    public static void setCorrectForCamera(boolean correctForCamera) {
        EventManager.correctForCamera = correctForCamera;
    }

    public static boolean pollEvent(EventData event) {
        // fixed mouse move event (doesnt lag), but seems not to be safe
        if (Mouse.getX() != lastX || Mouse.getY() != lastY) {
            event.type = EventTypes.MOUSE_MOVED;
            if(correctForCamera){
                float xRatio = Krapina.width / CameraManager.currentSize.x;
                float yRation = Krapina.height / CameraManager.currentSize.y;
                event.position = new Vector2f(Mouse.getX() / xRatio + CameraManager.relPosition.x - CameraManager.currentSize.x / 2,
                        Mouse.getY() / yRation + CameraManager.relPosition.y - CameraManager.currentSize.y / 2);
            } else {
                event.position = new Vector2f(Mouse.getX(), Mouse.getY());
            }

            lastX = Mouse.getX();
            lastY = Mouse.getY();

            return true;
        }
        // other "normal" events
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
                if(correctForCamera){
                    float xRatio = Krapina.width / CameraManager.currentSize.x;
                    float yRation = Krapina.height / CameraManager.currentSize.y;
                    event.position = new Vector2f(Mouse.getX() / xRatio + CameraManager.relPosition.x - CameraManager.currentSize.x / 2,
                            Mouse.getY() / yRation + CameraManager.relPosition.y - CameraManager.currentSize.y / 2);
                } else {
                    event.position = new Vector2f(Mouse.getX(), Mouse.getY());
                }
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
