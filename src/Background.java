public class LayerClass {

	public double speed;
	public double width;
	public double height;
	public double pos1, pos2;

	public LayerClass(){
		speed = 1.0;
		pos1 = 0.0;
		pos2 = width;
		width = 1000;
		height = 500;
	} 

	public void update(double dt){
		pos1 -= speed * dt;
		pos2 -= speed * dt;
		if( pos1 + width < 0 ) pos1 += width * 2;
		if( pos2 + width < 0 ) pos2 += width * 2;
	}

	public void draw(){
		// TODO: nacrtati ovdi
	}

}

public class BackgroundClass {

	public BackgroundClass(){
		LayerClass layer;
		layers.add(layer);
	}

	public void update(double dt){
		for( int i = 0; i < layers.size(); i++ ){
			layers[i].update(dt);
		}
	}

	public void draw(){
		for( int i = 0; i < layers.size(); i++ ){
			layers[i].draw();
		}
	}

	ArrayList<LayerClass> layers;

//1280 720
}