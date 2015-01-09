package THEGAME; /**
 * Created by nikola on 08.01.15..
 */


import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class DrawableEntity extends MovableEntity {

    public Vector2f size;
    public Vector3f color;
    private String textureName="";


    public DrawableEntity(){
        this(new Vector2f(0.0f, 0.0f));
    }

    public DrawableEntity(Vector2f pos, Vector2f size, Vector3f color){
        this(pos, size, color, new Vector2f(0.0f, 0.0f));
    }

    public DrawableEntity(Vector2f pos, Vector2f size, Vector3f color, Vector2f vel){
        super();
        this.velocity = vel;
        this.size = size;
        this.position = pos;
        this.color = color;
    }

    public DrawableEntity(Vector2f pos){
        this(pos, new Vector2f(0.0f, 0.0f), new Vector3f(1.0f, 1.0f, 1.0f));
    }

    public void setTexture(String _textureName, String texturePath){
        textureName = _textureName;
        AssetManager.addTexture(textureName, texturePath);
    }

    public void addForce(float x, float y){
        velocity.x+=x;
        velocity.y+=y;
    }

    public void draw(){
        draw_quad();
    }

    public void draw_quad(){
        System.out.println( size.x + " " + size.y );
        if( textureName == "" ){
            System.out.println("No texture set");
            return;
        }

        glPushMatrix();
        glTranslatef(position.x + size.x/2, position.y + size.y/2, 0.0f);
        glRotatef(rotation, 0.0f, 0.0f, 1.0f);
        glTranslated(-size.x/2, -size.y/2, 0.0f);

        glEnable(GL_TEXTURE_2D);
        AssetManager.useTexture(textureName);

        glColor3f(color.x, color.y, color.z);

        glBegin(GL_TRIANGLE_FAN);
            glVertex2f(0.0f, 0.0f);
            glTexCoord2f(0.0f,0.0f);
            glVertex2f(0.0f, size.y);
            glTexCoord2f(1.0f, 0.0f);
            glVertex2f(size.x, size.y);
            glTexCoord2f(1.0f, 1.0f);
            glVertex2f(size.x, 0.0f);
            glTexCoord2f(0.0f, 1.0f);
        glEnd();

        glDisable(GL_TEXTURE_2D);
        glPopMatrix();
    }

    public void drawPoint(){
        glPushMatrix();
        glTranslatef(position.x, position.y, 0);

        glColor3f(color.x, color.y, color.z);

        glBegin(GL_POINTS);
            glVertex2f(position.x, position.y);


    }

}
