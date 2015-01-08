package THEGAME;


import java.util.ArrayList;

public class BackgroundClass {

    private static LayerClass layer;

	public static void init(){
        layer = new LayerClass();
		DrawableEntity entity = new DrawableEntity();
		entity.setTexture("backgorund3", "res/background_3.png");
		entity.size.set(1024.0f, 512.0f);
		layer.addEntity(entity);
		entity = new DrawableEntity();
		entity.setTexture("background2", "res/background_2.png");
		entity.size.set(1024.0f, 512.0f);
		layer.addEntity(entity);
		entity = new DrawableEntity();
		entity.setTexture("background", "res/background.png");
		entity.size.set(1024.0f, 512.0f);
		layer.addEntity(entity);
    }

	public static void update(float dt){
		layer.update(dt);
	}

	public static void  draw(){
		layer.draw();
	}

//1280 720
}