package THEGAME;


import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.vector.Vector2f;

public class Background extends Entity{

    private LayerClass layer;
	private DrawableEntity sky[], mountains[], road[];
	public float targetX;

	public Background(){
		super();
		init();
	}

	public void init(){
        layer = new LayerClass();

		sky = new DrawableEntity[2];
		sky[0] = new DrawableEntity();
		sky[0].setTexture("sky_texture", "res/background_3.png");
		sky[0].size.set(1024.0f, 512.0f);
		sky[0].position.set(0.0f, 0.0f);
		sky[1] = new DrawableEntity();
		sky[1].setTexture("sky_texture", "res/background_3.png");
		sky[1].size.set(1024.0f, 512.0f);
		sky[1].position.set(1023.0f, 0.0f);
		layer.addEntity(sky[0]);
		layer.addEntity(sky[1]);

		mountains = new DrawableEntity[2];
		mountains[0] = new DrawableEntity();
		mountains[0].setTexture("mountains_texture", "res/background_2.png");
		mountains[0].size.set(1024.0f, 512.0f);
		mountains[0].position.set(0.0f, 0.0f);
		mountains[1] = new DrawableEntity();
		mountains[1].setTexture("mountains_texture", "res/background_2.png");
		mountains[1].size.set(1024.0f, 512.0f);
		mountains[1].position.set(1023.0f, 0.0f);
		layer.addEntity(mountains[0]);
		layer.addEntity(mountains[1]);

		road = new DrawableEntity[2];
		road[0] = new DrawableEntity();
		road[0].setTexture("road_texture", "res/background.png");
		road[0].size.set(1024.0f, 512.0f);
		road[0].position.set(0.0f, 0.0f);
		road[1] = new DrawableEntity();
		road[1].setTexture("road_texture", "res/background.png");
		road[1].size.set(1024.0f, 512.0f);
		road[1].position.set(1023.0f, 0.0f);
		layer.addEntity(road[0]);
		layer.addEntity(road[1]);
    }

	public void update(float dt){
		layer.update(dt);

		float dPosition = (targetX - this.position.x) / 1;
		for(int i = 0; i < 2; i++){
			sky[i].position.setX(sky[i].position.getX() - dPosition * 0.1f);
			mountains[i].position.setX(mountains[i].position.getX() - dPosition * 0.3f);
			road[i].position.setX(road[i].position.getX() - dPosition);

			if(sky[i].position.getX() < -sky[i].size.getX()) sky[i].position.setX( sky[i].position.getX() + sky[i].size.getX() * 2 - 1);
			if(mountains[i].position.getX() < -mountains[i].size.getX()) mountains[i].position.setX( mountains[i].position.getX() + mountains[i].size.getX() * 2 - 1);
			if(road[i].position.getX() < -road[i].size.getX()) road[i].position.setX( road[i].position.getX() + road[i].size.getX() * 2 - 1);
		}
		this.position.x += dPosition;
	}

	public void draw(){
		glPushMatrix();

		glTranslatef(this.position.x, this.position.y, 0.0f);
		layer.draw();

		glPopMatrix();
	}

//1280 720
}