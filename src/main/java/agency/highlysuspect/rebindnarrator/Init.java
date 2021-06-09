package agency.highlysuspect.rebindnarrator;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class Init implements ClientModInitializer {
	public static final KeyBinding NARRATOR_KEYBINDING = KeyBindingHelper.registerKeyBinding(new KeyBinding(
		"options.narrator",
		InputUtil.Type.KEYSYM,
		GLFW.GLFW_KEY_B,
		"key.categories.misc"
	));
	
	@Override
	public void onInitializeClient() {
		//Just classloads the above as a side effect. Magic happens in the mixin :)
	}
}
