package THEGAME;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Vehicle extends MovableEntity {
    //                      ---> MOVABLE ili STATIC ?!

    public static final int size = 15;

    public VehiclePart[][] matrix;

    public Vehicle() {
        super();
        matrix = new VehiclePart[size + 1][];
        for (int i = 0; i < size; ++i) {
            matrix[i] = new VehiclePart[size + 1];
        }


    }

    public boolean addPart(int x, int y, VehiclePart part) {
        for (int i = 0; i < part.w; ++i) {
            for (int j = 0; j < part.h; ++j) {
                if (matrix[i][j] != null) {
                    return false;
                }
            }
        }
        for (int i = 0; i < part.w; ++i) {
            for (int j = 0; j < part.h; ++j) {
                matrix[i][j] = part;
            }
        }
    }




}
