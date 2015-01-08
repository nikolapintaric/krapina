import java.util.ArrayList;

public class BackgroundClass {

    private static ArrayList<LayerClass> layers;

	public static void init(){
        layers = new ArrayList<LayerClass>();
		LayerClass layer = new LayerClass();
		layers.add(layer);

    }

	public static void update(double dt){
		for( int i = 0; i < layers.size(); i++ ){
			layers.get(i).update(dt);
		}
	}

	public static void  draw(){
        for( int i = 0; i < layers.size(); i++ ){
			layers.get(i).draw();
		}
	}

//1280 720
}