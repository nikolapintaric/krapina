package THEGAME;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
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
        Background.init();

        StateManager.pushState(new MenuState());
        StateManager.pushState(new GameState());

        //StateManager.changeState("MenuState");
        //StateManager.changeState("GameState");


        // aktivni STATE ce biti zadnji dodani - game state

        // isprobavanje assetmanagera
        AssetManager.addTexture("background", "res/background_2.png");
        AssetManager.useTexture("background");
        AssetManager.addFont("arial", "bok");

        ConfigManager config = new ConfigManager();
        config.parseFile("res/input.txt");
        config.writeToFile("res/test.txt");
    }

    public void run() {
        Debugger.log("Application.run()");
        StateManager.getState().update(1);
        loop();
    }

    public void loop() {
        Debugger.log("Application.loop()");

        /*long currentTime, lastTime;
        currentTime = lastTime = System.currentTimeMillis();*/

        // ovo bi se kasnije moglo zamijeniti s while (window opened())
        // ili necim slicno tome
        while (!Display.isCloseRequested()) {


            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(0, Krapina.width, 0, Krapina.height, 1, -1);
            glMatrixMode(GL_MODELVIEW);
            glLoadIdentity();

            StateManager.getState().draw();


            EventData event = new EventData();
            while (EventManager.pollEvent(event)) {
                //System.out.println(event.type + " " + event.keyCode);
                StateManager.getState().handleEvent(event);
            }

            /*currentTime = System.currentTimeMillis();
            if( (currentTime - lastTime) > 1000/60 ){
                float dt = (float)(currentTime - lastTime) / 1000.0f;
                StateManager.getState().update( dt );
                lastTime = currentTime;
            }*/

            StateManager.getState().update(1.0f/60);

            /*Background.draw();
            Background.update( 1.0f/60 );
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
