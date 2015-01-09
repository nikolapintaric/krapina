package THEGAME;

import THEGAME.module.VehicleModule;
import static org.lwjgl.opengl.GL11.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Vehicle extends MovableEntity {
    //                      ---> MOVABLE ili STATIC ?!

    public static final int size = 15;

    public VehicleModule[][] matrix;
    public ArrayList<VehicleModule> modules;

    public Vehicle() {
        super();
        matrix = new VehicleModule[size + 1][];
        for (int i = 0; i < size; ++i) {
            matrix[i] = new VehicleModule[size + 1];
        }

        modules = new ArrayList<VehicleModule>();

        this.position.set(100.0f, 100.0f);
    }

    public boolean addModule(VehicleModule part) {
        for (int i = 0; i < part.w; ++i) {
            for (int j = 0; j < part.h; ++j) {
                if (matrix[i + part.posx][j + part.posy] != null) {
                    System.out.println("Error addding part " + part.type + "; (" +(i+part.posx)+ ", " +(j+part.posy)+ ") already occupied");
                    return false;
                }
            }
        }

        for (int i = 0; i < part.w; ++i) {
            for (int j = 0; j < part.h; ++j) {
                matrix[i + part.posx][j + part.posy] = part;
            }
        }


        modules.add(part);

        return true;
    }

    public void removeModule(int x, int y) {
        // testirano, jednom, radilo
        if (matrix[x][y] == null) return;
        x = matrix[x][y].posx;
        y = matrix[x][y].posy;

        System.out.println("Removing " + matrix[x][y].type + "from (" + x + ", " + y + ")");

        // I don't even know...
        modules.remove(matrix[x][y]);

        int w = matrix[x][y].w;
        int h = matrix[x][y].h;
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < h; ++j) {
                matrix[x+i][y+j] = null;
            }
        }
    }

    public void update(float dt){
        for(int i = 0; i < modules.size(); i++){
            modules.get(i).update(dt);
        }
    }

    public void draw(){
        glPushMatrix();

        glTranslated(this.position.x, this.position.y, 0.0f);
        for(int i = 0; i < modules.size(); i++){
            modules.get(i).draw();
        }

        glPopMatrix();
    }

    public float mass, power;
    /*
    // such random very idk
    public void calculateVelocity() {
        mass = power = 0.0f;
        for (VehicleModule m: modules) {
            mass += m.mass;
            power += m.power;
        }
        velocity = power / mass;
    }
    */
}
