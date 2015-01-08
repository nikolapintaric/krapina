import java.util.ArrayList;

/**
 * Created by tonkosi on 07.01.15..
 */
public class StateManager {

    private static ArrayList<State> mStates;
    private static State mCurrentState = null;

    public StateManager() {
        mStates = new ArrayList<State>();
        mCurrentState = null;
    }

    public static void init() {
        mStates = new ArrayList<State>();
        mCurrentState = null;
    }

    /*
    * Pazite, ova funkcija se ne koristiti,
    * radije koristiti changeState !!!!
    * NIKAD NE KORISTITE OVO, na pocetku samo dodajte sve stateove
    * */
    public static void popState() {
        if (mStates.size() == 0) return;
        mStates.remove(mStates.size() - 1);
    }

    public static void pushState(State theState) {
        mStates.add(theState);
        mCurrentState = theState;
    }


    /*
    * Vraca trenutni state koji ne mora biti zadnji, nije STACK!!
    * */
    public static State getState() {
        if (mStates.size() == 0) return null;
        return mCurrentState;
        //return mStates.get(mStates.size() - 1);
    }


    public static void changeState(String stateName) {
        for (int i = 0; i < mStates.size(); ++i) {
            if (mStates.get(i).name == stateName) {
                mCurrentState = mStates.get(i);
                break;
            }
        }
    }

}
