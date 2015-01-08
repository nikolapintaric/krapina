package THEGAME;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by tonkosi on 07.01.15..
 */


public class Application {

    public Application() {

    }

    public void init() {
        Debugger.log("Application.init()");

        SetUpGL();

        StateManager.init();
        AssetManager.init();
        BackgroundClass.init();

        StateManager.pushState(new MenuState());
        StateManager.pushState(new GameState());

        // aktivni STATE ce biti zadnji dodani - game state

        // isprobavanje assetmanagera
        AssetManager.addAsset(new TextureAsset("background", "backgorund.jpg"));
        Asset ass = AssetManager.getAsset("background");
        Debugger.log(ass.name);
    }

    public void run() {
        Debugger.log("Application.run()");
        StateManager.getState().update(1);
        loop();
    }

    public void loop() {
        Debugger.log("Application.loop()");

        // ovo bi se kasnije moglo zamijeniti s while (window opened())
        // ili necim slicno tome
        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            StateManager.getState().draw();
            StateManager.getState().update(1.0f / 60);

            /*BackgroundClass.draw();
            BackgroundClass.update( 1.0f/60 );
*/
            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }



    public void SetUpGL(){

        try {
            Display.setDisplayMode(new DisplayMode(Krapina.width, Krapina.height));
            Display.setResizable(false);
            Display.create();
        } catch (LWJGLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);



        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Krapina.width, 0, Krapina.height, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();


    }

    public void kill() {

    }
}
