package THEGAME;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LayerClass {

	private ArrayList<DrawableEntity> entities;
	private float clean_cnt;

    public LayerClass(){
		entities = new ArrayList<DrawableEntity>();
		clean_cnt = 0.0f;
    }

	public void update(float dt){
		clean_cnt += dt;
		if(clean_cnt > 1.0f){
			clean_cnt = 0.0f;
			clean();
		}
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).update(dt);
		}
    }

	public void draw(){
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).draw();
		}
    }

	public void addEntity( DrawableEntity entity ){
		addEntity(entity, -1);
	}
	public void addEntity( DrawableEntity entity, int position  ){
		if( position == -1 ){
			entities.add( entity );
		} else {
			entities.add( position, entity );
		}
	}

	public void clean(){
		ArrayList<DrawableEntity> entities_new = new ArrayList<DrawableEntity>();
		for(int i = 0; i < entities.size(); i++){
			if(entities.get(i) == null) continue;
			entities_new.add(entities.get(i));
		}
		entities = entities_new;
	}
}
