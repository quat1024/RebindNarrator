package agency.highlysuspect.rebindnarrator;

import net.minecraft.client.gui.screens.Screen;

public abstract class RebindNarrator {
	/**
	 * Global variable. The current implementation of RebindNarrator.
	 */
	public static RebindNarrator IMPL;
	
	/**
	 * GLFW sometimes calls these "key tokens", https://www.glfw.org/docs/3.3/input_guide.html#input_key .
	 * I believe this mapping originated in GLFW and is otherwise non-standard. They are not key codes or key scancodes.
	 * 
	 * @param glfwKeyToken the token of the currently pressed key
	 * @return whether that key should toggle the narrator
	 */
	public boolean isCorrectKey(int glfwKeyToken) {
		return glfwKeyToken == 66;
	}
	
	/**
	 * @return whether the correct modifier keys are being pressed.
	 */
	public boolean correctModifiersPressed() {
		return Screen.hasControlDown();
	}
}
