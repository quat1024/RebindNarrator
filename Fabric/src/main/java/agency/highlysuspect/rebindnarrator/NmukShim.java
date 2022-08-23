package agency.highlysuspect.rebindnarrator;

import net.minecraft.client.KeyMapping;

import java.util.List;

/**
 * No More Useless Keys allows assigning multiple keys to the same action.
 * This is a passthrough implementation for when the mod is not installed.
 */
public class NmukShim {
	public static NmukShim INST = new NmukShim();
	
	public List<KeyMapping> getSelfAndAlternatives(KeyMapping self) {
		return List.of(self);
	}
}
