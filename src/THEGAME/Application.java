package THEGAME;

import THEGAME.manager.AssetManager;
import THEGAME.manager.ConfigManager;
import THEGAME.manager.EventManager;
import THEGAME.manager.StateManager;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by tonkosi on 07.01.15..
 */


public class Application {
    public float dt = 1 / 60.0f, lastFrame, lastTime;
    public int fps;

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


        boolean running = true;
        while (!Display.isCloseRequested() && running) {


            glClear(GL_COLOR_BUFFER_BIT);


            StateManager.getState().draw();


            EventData event = new EventData();
            while (EventManager.pollEvent(event)) {
                //System.out.println(event.type + " " + event.keyCode);
                StateManager.getState().handleEvent(event);
                if(event.type == EventTypes.KEY_PRESSED && event.keyCode == Keyboard.KEY_ESCAPE)
                    running = false;
            }

            /*currentTime = System.currentTimeMillis();
            if( (currentTime - lastTime) > 1000/60 ){
                float dt = (float)(currentTime - lastTime) / 1000.0f;
                StateManager.getState().update( dt );
                lastTime = currentTime;
            }*/

            StateManager.getState().update(1 / 60.0f);

            /*Background.draw();
            Background.update( 1.0f/60 );
*/

            fps();
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

    private void fps(){
        dt = System.nanoTime() / 1000000000.0f - lastFrame / 1000.0f;
        fps++;
        lastFrame = System.nanoTime() / 1000000.0f;
        if(System.nanoTime() / 1000000.0f - lastTime > 1000){
            System.out.println(fps);
            fps = 0;
            lastTime = System.nanoTime() / 1000000.0f;
        }
    }

    public void kill() {

    }
}
