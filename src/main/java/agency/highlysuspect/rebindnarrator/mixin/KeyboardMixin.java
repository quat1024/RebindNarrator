package agency.highlysuspect.rebindnarrator.mixin;

import agency.highlysuspect.rebindnarrator.Init;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Keyboard.class)
public class KeyboardMixin {
	@ModifyConstant(
		method = "onKey",
		constant = @Constant(intValue = 66) //GLFW.GLFW_KEY_B
	)
	private int narrator(int old) {
		return KeyBindingHelper.getBoundKeyOf(Init.NARRATOR_KEYBINDING).getCode();
	}
}
