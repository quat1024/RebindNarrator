package agency.highlysuspect.rebindnarrator;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod("rebind_narrator")
public class ForgeInit {
	public ForgeInit(IEventBus modBus) {
		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> IExtensionPoint.DisplayTest.IGNORESERVERONLY, (a, b) -> true)); //Quality modloader
		
		//distexecutor is deprecated. okay
		if(FMLEnvironment.dist == Dist.CLIENT) {
			CoolClientEntrypointEpic.doIt(modBus);
		}
	}
	
	public static class CoolClientEntrypointEpic {
		public static void doIt(IEventBus modBus) {
			RebindNarrator.IMPL = new ForgeImpl(modBus);
		}
	}
}