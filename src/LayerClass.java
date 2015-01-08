import jdk.nashorn.internal.runtime.Debug;
import org.lwjgl.util.vector.Vector2f;

public class LayerClass {

	public float speed;
	public float width;
	public float height;
	public float pos1, pos2;
    private Quad quad1, quad2;


    public LayerClass( int x ){
		speed = 100.0f;
		width = 1000.0f;
		height = 500.0f;
		pos1 = 0.0f;
		pos2 = width - 0.1f;
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
		pos1 -= speed * dt;
		pos2 -= speed * dt;
		if( pos1 + width < 0 ) pos1 += width * 2;
		if( pos2 + width < 0 ) pos2 += width * 2;
        quad1.position.set(pos1, 0);
        quad2.position.set(pos2, 0);
    }


	public void draw(){
        quad1.draw();
        quad2.draw();
    }

}
