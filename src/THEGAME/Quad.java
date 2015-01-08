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
        private Texture texture1, texture2, texture3;
        public int tmp;

        private int vboId, vaoId, vertexCount;

        public Quad(){
            //this(10, 10);
        }

        public Quad(float x, float y){
            size = new Vector2f(x, y);
            position = new Vector2f(0, 0);
            float[] vertices = {
                    0f, 0f, 0f,
                    size.x, 0f, 0f,
                    0f, size.y, 0f,
                    0f, size.y, 0f,
                    size.x, 0f, 0f,
                    size.x, size.y, 0f
            };

            try {
                texture1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/background.png"));
                texture2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/background_2.png"));
                texture3 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/background_3.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }


            /*
            FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
            verticesBuffer.put(vertices);
            verticesBuffer.flip();

            vertexCount = 6;


            vaoId = glGenVertexArrays();
            glBindVertexArray(vaoId);

            vboId = glGenBuffers();
            glBindBuffer(GL_ARRAY_BUFFER, vboId);
            glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
            glBindBuffer(GL_ARRAY_BUFFER, 0);
            glBindVertexArray(0);
            */


        }

        public void addForce(float x, float y){
            velocity.x+=x;
            velocity.y+=y;
        }

        public void tick(){

        }

        public void draw(){
            glPushMatrix();
            glTranslatef(position.x, position.y, 0);


            /*glBindVertexArray(vaoId);
            glEnableVertexAttribArray(0);

            glDrawArrays(GL_TRIANGLES, 0, vertexCount);

            glDisableVertexAttribArray(0);
            glBindVertexArray(0);

            glLoadIdentity();*/

//           texture.bind();
            glEnable(GL_TEXTURE_2D);
            if( tmp == 0 ){
                glBindTexture(GL_TEXTURE_2D, texture1.getTextureID());
            }
            if( tmp == 1 ){
                glBindTexture(GL_TEXTURE_2D, texture2.getTextureID());
            }
            if( tmp == 2 ){
                glBindTexture(GL_TEXTURE_2D, texture3.getTextureID());
            }
//            glColor3f(1.0f, 1.0f, 1.0f);
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

            glPopMatrix();
        }

}