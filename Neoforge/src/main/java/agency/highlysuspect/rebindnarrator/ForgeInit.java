package agency.highlysuspect.rebindnarrator;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = "rebind_narrator", dist = Dist.CLIENT)
public class ForgeInit {
	public ForgeInit(IEventBus modBus) {
		RebindNarrator.IMPL = new ForgeImpl(modBus);
	}
}
