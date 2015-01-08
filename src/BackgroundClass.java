import java.util.ArrayList;

public class BackgroundClass {

    private ArrayList<LayerClass> layers;

	public BackgroundClass(){
        layers = new ArrayList<LayerClass>();
		LayerClass layer = new LayerClass();
		layers.add(layer);

    }

	public void update(double dt){
		for( int i = 0; i < layers.size(); i++ ){
			layers.get(i).update(dt);
		}
	}

	public void draw(){
		for( int i = 0; i < layers.size(); i++ ){
			layers.get(i).draw();
		}
	}

//1280 720
}