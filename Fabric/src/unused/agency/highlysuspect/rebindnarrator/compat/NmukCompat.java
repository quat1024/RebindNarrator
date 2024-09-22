package agency.highlysuspect.rebindnarrator.compat;

import agency.highlysuspect.rebindnarrator.NmukShim;
import de.siphalor.nmuk.api.NMUKAlternatives;
import net.minecraft.client.KeyMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * No More Useless Keys allows assigning multiple keys to the same action.
 * If the mod is installed, we need to iterate through each keybinding.
 */
public class NmukCompat extends NmukShim {
	@Override
	public List<KeyMapping> getSelfAndAlternatives(KeyMapping self) {
		ArrayList<KeyMapping> real = new ArrayList<>(2);
		real.add(self);
		
		List<KeyMapping> alternates = NMUKAlternatives.getAlternatives(self);
		if(alternates != null && !alternates.isEmpty()) real.addAll(alternates);
		
		return real;
	}
}
