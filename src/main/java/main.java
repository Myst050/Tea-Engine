import tea.Display;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


public class main {
    public static void Main(String[] args){
        System.out.println("HELLO TEA ENGINE");

        Display.create(800, 600, "Tea Engine");

        Display.setHint(GLFW_RESIZABLE, GLFW_TRUE);

        while(!Display.isClosed()){
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            Display.loop();
        }
        Display.destroy();
    }
}
