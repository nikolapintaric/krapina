package THEGAME;

/**
 * Created by tonkosi on 08.01.15..
 */
public class Debugger {

    public static boolean enabled = true;

    public static void log(Object o) {
        if (enabled) {
            System.out.println(o.toString());
        }
    }

}
