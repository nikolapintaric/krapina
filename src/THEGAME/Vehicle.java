package THEGAME;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Vehicle extends Entity {
    //                      ---> MOVABLE ili STATIC ?!

    public static final int size = 15;

    public Entity[][] matrix;

    public Vehicle() {
        super();
        matrix = new Entity[size + 1][];
        for (int i = 0; i < size; ++i) {
            matrix[i] = new Entity[size + 1];
        }

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {

            }
        }
    }





}
