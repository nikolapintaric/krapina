package THEGAME;

public class LayerClass {

	public float speed;
	public float width;
	public float height;
	public float pos1, pos2;
	public float offset;
    private Quad quad1, quad2;


    public LayerClass( int x ){
		offset = 1.0f;
		speed = 100.0f;
		width = 1000.0f;
		height = 500.0f;
		pos1 = 0.0f;
		pos2 = width - offset;
	    quad1 = new Quad(0, 0);
        quad2 = new Quad(0, 0);
        quad1.size.set(width, height);
        quad2.size.set(width, height);
		quad1.tmp = x;
		quad2.tmp = x;
    }

	public void setSpeed(float _speed){
		speed = _speed;
	}

	public void update(double dt){
		pos2 -= speed * dt;
		pos1 -= speed * dt;
		if( pos2 + width < 0 ) pos2 += width * 2 - offset;
		if( pos1 + width < 0 ) pos1 += width * 2 - offset;
        quad2.position.set(pos2, 0);
        quad1.position.set(pos1, 0);
		speed *= 1.001f;
    }


	public void draw(){
        quad1.draw();
        quad2.draw();
    }

}
