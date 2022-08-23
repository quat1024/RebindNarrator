package agency.highlysuspect.rebindnarrator.compat;

import agency.highlysuspect.rebindnarrator.RebindNarrator;
import com.mojang.blaze3d.platform.InputConstants;
import de.siphalor.amecs.api.AmecsKeyBinding;
import de.siphalor.amecs.api.KeyModifiers;
import de.siphalor.amecs.impl.duck.IKeyBinding;
import de.siphalor.nmuk.api.NMUKAlternatives;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

import java.util.List;

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
		if(glfwKeyToken == KeyBindingHelper.getBoundKeyOf(NARRATOR_KEY).getValue() && ((IKeyBinding) NARRATOR_KEY).amecs$getKeyModifiers().isPressed()) {
			return true;
		}
		
		//Amecs extends NMUK, so I need to check NMUK alternatives as well.
		List<KeyMapping> alternatives = NMUKAlternatives.getAlternatives(NARRATOR_KEY);
		if(alternatives == null) return false;
		
		for(KeyMapping alt : alternatives) {
			if(glfwKeyToken == KeyBindingHelper.getBoundKeyOf(alt).getValue() && ((IKeyBinding) alt).amecs$getKeyModifiers().isPressed()) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean correctModifiersPressed() {
		//Just kidding, modifiers are actually checked in isCorrectKey, above. 
		//It is done like this because:
		//- AMECS users can set different sets of modifiers for each alternative keybind, so I need to check them at the same time I check their main key 
		//- redirecting Screen.hasControlDown to return an unconditional `true` makes me feel a bit icky, I'd rather not do it if I'm not doing AMECS compat
		return true;
	}
}
