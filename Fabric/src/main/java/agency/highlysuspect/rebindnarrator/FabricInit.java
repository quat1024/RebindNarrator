package agency.highlysuspect.rebindnarrator;

import agency.highlysuspect.rebindnarrator.compat.FabricAmecsImpl;
import agency.highlysuspect.rebindnarrator.compat.FabricNmukImpl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;

public class FabricInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if(FabricLoader.getInstance().isModLoaded("amecs")) {
			LogManager.getLogger("rebind-narrator").info("[Rebind Narrator] AMECS is present. Loading FabricAmecsImpl.");
			RebindNarrator.IMPL = new FabricAmecsImpl();
		} else if(FabricLoader.getInstance().isModLoaded("nmuk")) {
			LogManager.getLogger("rebind-narrator").info("[Rebind Narrator] NoMoreUselessKeys (but not AMECS) is present. Loading FabricNmukImpl.");
			RebindNarrator.IMPL = new FabricNmukImpl();
		} else {
			LogManager.getLogger("rebind-narrator").info("[Rebind Narrator] AMECS/NoMoreUselessKeys not found. Loading basic FabricImpl.");
			RebindNarrator.IMPL = new FabricImpl();
		}
	}
}
