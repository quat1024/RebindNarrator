package agency.highlysuspect.rebindnarrator;

import agency.highlysuspect.rebindnarrator.compat.FabricAmecsImpl;
import agency.highlysuspect.rebindnarrator.compat.NmukCompat;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;

public class FabricInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if(FabricLoader.getInstance().isModLoaded("nmuk")) {
			LogManager.getLogger("rebind_narrator").info("[Rebind Narrator] NoMoreUselessKeys is present. Loading NmukCompat");
			NmukShim.INST = new NmukCompat();
		}
		
		if(FabricLoader.getInstance().isModLoaded("amecs") && FabricLoader.getInstance().isModLoaded("amecsapi")) {
			LogManager.getLogger("rebind_narrator").info("[Rebind Narrator] AMECS is present. Loading FabricAmecsImpl.");
			RebindNarrator.IMPL = new FabricAmecsImpl();
		} else {
			RebindNarrator.IMPL = new FabricImpl();
		}
	}
}
