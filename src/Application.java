/**
 * Created by tonkosi on 07.01.15..
 */
public class Application {

    private StateManager mStateManager;

    public Application() {

    }

    public void init() {
        mStateManager = new StateManager();
        mStateManager.pushState(new MenuState());
        mStateManager.pushState(new GameState());
    }

    public void run() {
        System.out.println("kaj ima njofra");
        mStateManager.getState().update(1);
    }

    public void kill() {

    }
}
