package THEGAME; /**
 * Created by nikola on 08.01.15..
 */


import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class DrawableEntity extends MovableEntity {

        public Vector2f size;
        public Color color;
        private String textureName;


        public DrawableEntity(){
            size = new Vector2f(0.0f, 0.0f);
        }

        public DrawableEntity(Vector2f pos, Vector2f size){
            this.size = size;
            position = pos;
        }

        public DrawableEntity(Vector2f pos){
            position = pos;
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
            if( textureName == "" ){
                System.out.println("No texture set");
                return;
            }

            glPushMatrix();
            glTranslatef(position.x, position.y, 0);

            glEnable(GL_TEXTURE_2D);
            AssetManager.useTexture(textureName);

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

}
