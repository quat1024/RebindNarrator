package quaternary.rebindnarratorcore;

import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.*;

public class ModContainer extends DummyModContainer {
	public ModContainer() {
		super(new ModMetadata());
		ModMetadata md = getMetadata();
		md.modId = "rebind_vanilla_core";
		md.name = "Rebind Vanilla Core";
		md.description = "Tiny coremod to disable the hardcoded narrator hotkey (Rebind Vanilla Keys readds it)";
		md.version = "0";
	}
	
	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		return true;
	}
}
