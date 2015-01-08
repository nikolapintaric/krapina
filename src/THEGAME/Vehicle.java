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

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {

            }
        }
    }





}
