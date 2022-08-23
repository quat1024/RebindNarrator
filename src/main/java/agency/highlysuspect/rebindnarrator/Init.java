package agency.highlysuspect.rebindnarrator;

import net.fabricmc.api.ClientModInitializer;

public class Init implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		RebindNarrator.IMPL = new RebindNarratorFabricImpl();
	}
}
