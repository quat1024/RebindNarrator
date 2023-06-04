package agency.highlysuspect.rebindnarrator.compat;

import agency.highlysuspect.rebindnarrator.NmukShim;
import agency.highlysuspect.rebindnarrator.RebindNarrator;
import com.mojang.blaze3d.platform.InputConstants;
import de.siphalor.amecs.api.AmecsKeyBinding;
import de.siphalor.amecs.api.KeyModifiers;
import de.siphalor.amecs.impl.duck.IKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

/**
 * AMECS adds the ability to assign Ctrl, Shift, and Alt modifiers to a keybinding. With this mod installed,
 * we should respect the AMECS key settings, instead of the vanilla behavior of requiring Control to be pressed.
 */
public class FabricAmecsImpl extends RebindNarrator {
	public static final KeyMapping NARRATOR_KEY = KeyBindingHelper.registerKeyBinding(new AmecsKeyBinding(
		"options.narrator",
		InputConstants.Type.KEYSYM,
		GLFW.GLFW_KEY_B,
		"key.categories.misc",
		new KeyModifiers().setControl(true)
	));
	
	@Override
	public boolean isCorrectKey(int glfwKeyToken) {
		for(KeyMapping alt : NmukShim.INST.getSelfAndAlternatives(NARRATOR_KEY)) {
			if(glfwKeyToken == KeyBindingHelper.getBoundKeyOf(alt).getValue() && ((IKeyBinding) alt).amecs$getKeyModifiers().isPressed()) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean correctModifiersPressed() {
		//Just kidding, modifiers are actually checked in isCorrectKey, above. 
		//It is done like this because AMECS+NMUK users can set different sets of modifiers for each alternative bind,
		//so I need to check them at the same time I check their main key.
		return true;
	}
}
