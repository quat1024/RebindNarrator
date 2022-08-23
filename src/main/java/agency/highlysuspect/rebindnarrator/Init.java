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
	
	public static int getNarratorKeyToken() {
		//GLFW sometimes calls these "key tokens", https://www.glfw.org/docs/3.3/input_guide.html#input_key .
		//I believe this mapping originated in GLFW and is otherwise non-standard.
		
		//This function returns -1 when the keybinding is not bound by the user. This is safe.
		//InputConstants.UNKNOWN defaults to key token -1, and keySmoothCamera and keySpectatorOutlines
		//are bound to -1 by default as well.
		InputConstants.Key boundKey = KeyBindingHelper.getBoundKeyOf(NARRATOR_KEYBINDING);
		return boundKey.getValue();
	}
	
	@Override
	public void onInitializeClient() {
		//Just classloads the above as a side effect. Magic happens in the mixin :)
	}
}
