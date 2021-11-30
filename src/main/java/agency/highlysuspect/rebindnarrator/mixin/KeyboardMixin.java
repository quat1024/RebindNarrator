package agency.highlysuspect.rebindnarrator.mixin;

import agency.highlysuspect.rebindnarrator.Init;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(KeyboardHandler.class)
public class KeyboardMixin {
	@ModifyConstant(
		method = "keyPress(JIIII)V",
		constant = @Constant(intValue = 66) //GLFW.GLFW_KEY_B
	)
	private int narrator(int old) {
		return KeyBindingHelper.getBoundKeyOf(Init.NARRATOR_KEYBINDING).getValue();
	}
}
