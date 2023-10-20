package agency.highlysuspect.rebindnarrator;

import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;

public class RebindNarrator {
	/**
	 * Global variable. The current implementation of RebindNarrator.
	 * The implementation defined in this class is a simple reimplementation of the vanilla logic.
	 */
	public static RebindNarrator IMPL = new RebindNarrator();
	
	/**
	 * GLFW sometimes calls these "key tokens", https://www.glfw.org/docs/3.3/input_guide.html#input_key .
	 * I believe this mapping originated in GLFW and is otherwise non-standard. They are not key codes or key scancodes.
	 * 
	 * @param glfwKeyToken the token of the currently pressed key
	 * @return whether that key should toggle the narrator
	 */
	public boolean isCorrectKey(int glfwKeyToken) {
		return glfwKeyToken == GLFW.GLFW_KEY_B;
	}
	
	/**
	 * @return whether the correct modifier keys are being pressed.
	 */
	public boolean correctModifiersPressed() {
		return Screen.hasControlDown();
	}
}
