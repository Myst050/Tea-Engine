package tea;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Display {
    private static long window;
    private static int width;
    private static int height;
    private static String title;

    public static void create(int w, int h, String t){
        width = w;
        height = h;
        title = t;


        GLFWErrorCallback.createPrint(System.err).set();

        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW!");
        }

        glfwDefaultWindowHints();

        window = glfwCreateWindow(width, height, title, NULL, NULL);

        GL.createCapabilities();
        glfwSwapInterval(1);
        glfwShowWindow(window);
    }

    public static void loop(){
        glfwSwapBuffers(window);

        glfwPollEvents();
    }

    public static boolean isClosed() {
        return glfwWindowShouldClose(window);
    }

    public static void setHint(int Hint, int enable){
        glfwWindowHint(Hint, enable);
    }

    public static void destroy(){
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}
