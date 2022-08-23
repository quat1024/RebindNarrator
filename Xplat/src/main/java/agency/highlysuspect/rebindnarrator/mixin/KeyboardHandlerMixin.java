package agency.highlysuspect.rebindnarrator.mixin;

import agency.highlysuspect.rebindnarrator.RebindNarrator;
import net.minecraft.client.KeyboardHandler;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {
	//keyB -> the original constant targeted by ModifyConstant (66, GLFW_KEY_B)
	//window, key, scancode, action, mods -> original method parameters, from GLFWKeyCallbackI.
	@ModifyConstant(method = "keyPress", constant = @Constant(intValue = GLFW.GLFW_KEY_B))
	private int rebindnarrator$keyPress$modifyConst(int keyB, long windowHandle, int key, int scancode, int action, int mods) {
		//This constant (which is normally 66, the B key) is compared with the method's argument "key".
		//If they are the same, narrator cycling code is invoked.
		//To prevent narrator code from running, I must return anything other than "key".
		int notKey = key + 1;
		
		if(key == GLFW.GLFW_KEY_UNKNOWN) return notKey;
		else return RebindNarrator.IMPL.isCorrectKey(key) ? key : notKey;
	}
	
	@Redirect(method = "keyPress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/Screen;hasControlDown()Z"))
	private boolean rebindnarrator$keyPress$redirHasControlDown() {
		return RebindNarrator.IMPL.correctModifiersPressed();
	}
}
