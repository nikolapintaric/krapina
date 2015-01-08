package THEGAME; /**
 * Created by nikola on 08.01.15..
 */


import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Quad extends MovableEntity {

        public Vector2f size;
        private String texture;

        private int vboId, vaoId, vertexCount;

        public Quad(){
        }

        public Quad(float x, float y){
            size = new Vector2f(x, y);
            position = new Vector2f(0, 0);
        }

        public void addForce(float x, float y){
            velocity.x+=x;
            velocity.y+=y;
        }

        public void draw(){
            glPushMatrix();
            glTranslatef(position.x, position.y, 0);

            glEnable(GL_TEXTURE_2D);
                //TODO: call use texture
                //glBindTexture(GL_TEXTURE_2D, texture2.getTextureID());

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
