package agency.highlysuspect.rebindnarrator.mixin;

import agency.highlysuspect.rebindnarrator.Init;
import net.minecraft.client.KeyboardHandler;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {
	//keyB -> the original constant targeted by ModifyConstant (66, GLFW_KEY_B)
	//window, key, scancode, action, mods -> original method parameters, from GLFWKeyCallbackI.
	//Returning a value that equals "key" will cause the == check to pass and the narrator code will be invoked.
	@ModifyConstant(method = "keyPress(JIIII)V", constant = @Constant(intValue = GLFW.GLFW_KEY_B))
	private int narrator(int keyB, long windowHandle, int key, int scancode, int action, int mods) {
		return Init.getNarratorKeyToken();
	}
}
