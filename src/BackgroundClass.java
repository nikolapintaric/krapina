import sun.plugin.javascript.navig4.Layer;

import java.util.ArrayList;

public class BackgroundClass {

    private static ArrayList<LayerClass> layers;

	public static void init(){
        layers = new ArrayList<LayerClass>();
		LayerClass layer = new LayerClass(0);
		LayerClass layer2 = new LayerClass(1);
		LayerClass layer3 = new LayerClass(2);
		layer2.setSpeed(30.0f);
		layer3.setSpeed(10.0f);
		layers.add(layer3);
		layers.add(layer2);
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