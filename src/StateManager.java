import java.util.ArrayList;

/**
 * Created by tonkosi on 07.01.15..
 */
public class StateManager {

    private ArrayList<State> mStates;

    public StateManager() {
        mStates = new ArrayList<State>();
    }

    public void popState() {
        if (mStates.size() == 0) return;
        mStates.remove(mStates.size() - 1);
    }

    public void pushState(State theState) {
        mStates.add(theState);
    }


    public State getState() {
        if (mStates.size() == 0) return null;
        return mStates.get(mStates.size() - 1);
    }


    public void changeState(String stateName) {
        /*for (int i = 0; i < mStates.size(); ++i) {
            if (mStates.get(i).name == stateName)
                break;
        }*/
    }

}
