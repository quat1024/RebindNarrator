package agency.highlysuspect.rebindnarrator;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class Init implements ClientModInitializer {
	public static final KeyMapping NARRATOR_KEYBINDING = KeyBindingHelper.registerKeyBinding(new KeyMapping(
		"options.narrator",
		InputConstants.Type.KEYSYM,
		GLFW.GLFW_KEY_B,
		"key.categories.misc"
	));
	
	@Override
	public void onInitializeClient() {
		//Just classloads the above as a side effect. Magic happens in the mixin :)
	}
}
