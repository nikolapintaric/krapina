package THEGAME.manager;

import static org.lwjgl.opengl.GL11.*;

import javafx.scene.Camera;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector4f;

import java.util.Vector;

/**
 * Created by Mihael on 1/11/2015.
 */
public class CameraManager {
    public static Vector4f boundingRect;
    public static Vector4f currentRect;
    public static float zoom;
    public static float targetZoom;
    public static Vector2f relPosition; // relative to bounding rectangle, center of camera
    public static Vector2f currentSize;

    public static void init(){
        boundingRect = new Vector4f(0.0f, 0.0f, 0.0f, 0.0f);
        currentRect = new Vector4f(0.0f, 0.0f, 0.0f, 0.0f);
        zoom = targetZoom = 1.0f;
        relPosition = new Vector2f(0.0f, 0.0f);
        currentSize = new Vector2f(0.0f, 0.0f);
    }

    public static void setBoundingRect(Vector4f boundingRect) {
        CameraManager.boundingRect = boundingRect;
        updateCurrentRect();
    }
    public static void setZoom(float zoom) {
        CameraManager.zoom = CameraManager.targetZoom = zoom;
        updateCurrentRect();
    }
    public static void setRelPosition(Vector2f relPosition) {
        CameraManager.relPosition = relPosition;
        updateCurrentRect();
    }
    public static void moveRelPosition(Vector2f deltaPosition){
        CameraManager.relPosition.x += deltaPosition.x;
        CameraManager.relPosition.y += deltaPosition.y;
        updateCurrentRect();
    }

    public static void setTargetZoom(float targetZoom) {
        CameraManager.targetZoom = targetZoom;
    }

    public static void update(){
        zoom += (targetZoom - zoom) / 20;
        updateCurrentRect();
    }

    private static void updateCurrentSize(){
        currentSize = new Vector2f( (boundingRect.z - boundingRect.x) / zoom, (boundingRect.w - boundingRect.y) / zoom );
    }

    private static void updateCurrentRect(){
        updateCurrentSize();
        Vector2f lowerLeftPoint = new Vector2f( (relPosition.x - currentSize.x / 2), (relPosition.y - currentSize.y / 2) );
        currentRect.setX(lowerLeftPoint.x + boundingRect.x);
        currentRect.setY(lowerLeftPoint.y + boundingRect.y);
        currentRect.setZ(currentRect.x + currentSize.x);
        currentRect.setW(currentRect.y + currentSize.y);
    }

    public static void applyProjectionTransformations(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        glOrtho(0, currentSize.x, 0, currentSize.y, 1, -1);
        glTranslatef(-(currentRect.x), -(currentRect.y), 0.0f);
    }
}