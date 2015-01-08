/**
 * Created by nikola on 08.01.15..
 */


import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector2f;


public class Quad extends MovableEntity{




        public Vector2f size;

        private int vboId, vaoId, vertexCount;

        public Quad(){
            //this(10, 10);
        }

        public Quad(float x, float y){
            size = new Vector2f(x, y);
            float[] vertices = {
                    0f, 0f, 0f,
                    size.x, 0f, 0f,
                    0f, size.y, 0f,
                    0f, size.y, 0f,
                    size.x, 0f, 0f,
                    size.x, size.y, 0f
            };

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


        }

        public void addForce(float x, float y){
            velocity.x+=x;
            velocity.y+=y;
        }

        public void tick(){

        }

        public void draw(){
            glTranslatef(position.x + size.x/2, position.y + size.y/2, 0);
            glTranslatef(-size.x/2, -size.y/2, 0);

            glBindVertexArray(vaoId);
            glEnableVertexAttribArray(0);

            glDrawArrays(GL_TRIANGLES, 0, vertexCount);

            glDisableVertexAttribArray(0);
            glBindVertexArray(0);

            glLoadIdentity();

        }

}
