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

        // po DEFAULTU je selektiran ZADNJI dodani state
        mStateManager.changeState("MenuState");
    }

    public void run() {
        System.out.println("kaj ima njofra");
        mStateManager.getState().update(1);
        loop();
    }

    public void loop() {
        // ovo bi se kasnije moglo zamijeniti s while (window opened())
        // ili necim slicno tome
        while (true) {

        }
    }

    public void kill() {

    }
}
