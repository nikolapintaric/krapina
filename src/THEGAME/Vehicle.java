package THEGAME;

import THEGAME.module.VehicleModule;

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


    }

    public boolean addPart(int x, int y, VehicleModule part) {
        for (int i = 0; i < part.w; ++i) {
            for (int j = 0; j < part.h; ++j) {
                if (matrix[i+x][j+y] != null) {
                    return false;
                }
            }
        }

        for (int i = 0; i < part.w; ++i) {
            for (int j = 0; j < part.h; ++j) {
                matrix[i+x][j+y] = part;
            }
        }
        part.posx = x;
        part.posy = y;

        modules.add(part);

        return true;
    }

    public void removePart(int x, int y) {
        // jel ovo radi?
        x = matrix[x][y].posx;
        y = matrix[x][y].posy;

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
