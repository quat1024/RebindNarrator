package agency.highlysuspect.rebindnarrator.compat;

import agency.highlysuspect.rebindnarrator.FabricImpl;
import de.siphalor.nmuk.api.NMUKAlternatives;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;

import java.util.List;

/**
 * No More Useless Keys adds the ability to add alternatives to keybindings. You can bind "move forward" to both W and something else.
 * Therefore, I need to check both the main keybinding and all the NMUK alternatives.
 */
public class FabricNmukImpl extends FabricImpl {
	@Override
	public boolean isCorrectKey(int glfwKeyToken) {
		boolean mainKeyCorrect = super.isCorrectKey(glfwKeyToken);
		if(mainKeyCorrect) return true;
		
		List<KeyMapping> alternatives = NMUKAlternatives.getAlternatives(NARRATOR_KEY);
		if(alternatives == null) return false;
		else for(KeyMapping alt : alternatives) {
			if(glfwKeyToken == KeyBindingHelper.getBoundKeyOf(alt).getValue()) return true;
		}
		return false;
	}
}
