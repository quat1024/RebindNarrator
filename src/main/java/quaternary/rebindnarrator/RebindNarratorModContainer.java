package quaternary.rebindnarrator;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.relauncher.Side;

public final class RebindNarratorModContainer extends DummyModContainer {
	public static final String MODID = "rebind_narrator";
	public static final String NAME = "Rebind Narrator";
	public static final String VERSION = "GRADLE:VERSION";

	private static final ModMetadata METADATA = new ModMetadata();

	static {
		METADATA.modId = RebindNarratorModContainer.MODID;
		METADATA.name = RebindNarratorModContainer.NAME;
		METADATA.version = RebindNarratorModContainer.VERSION;
		METADATA.description = "Rebind the narrator key!";
		METADATA.authorList = ImmutableList.of("quaternary", "InsomniaKitten");
		METADATA.credits = "Mojang, for forgetting to add this keybind :OMEGALUL:";
	}

	public RebindNarratorModContainer() {
		super(METADATA);
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		if (shouldLoadInEnvironment()) {
			// Register KeybindEvents instance for lifecycle events
			// Events use com.google.common.eventbus.Subscribe
			bus.register(new KeybindEvents());
			return true;
		} else return false;
	}

	@Override
	public boolean shouldLoadInEnvironment() {
		// Only load this mod instance on the physical client
		return FMLCommonHandler.instance().getSide() == Side.CLIENT;
	}
}
