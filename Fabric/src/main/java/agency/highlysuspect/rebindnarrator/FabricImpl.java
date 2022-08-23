package agency.highlysuspect.rebindnarrator;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class FabricImpl extends RebindNarrator {
	public final KeyMapping NARRATOR_KEY = KeyBindingHelper.registerKeyBinding(new KeyMapping(
		"options.narrator",
		InputConstants.Type.KEYSYM,
		GLFW.GLFW_KEY_B,
		"key.categories.misc"
	));
	
	@Override
	public boolean isCorrectKey(int glfwKeyToken) {
		return glfwKeyToken == KeyBindingHelper.getBoundKeyOf(NARRATOR_KEY).getValue();
	}
}
