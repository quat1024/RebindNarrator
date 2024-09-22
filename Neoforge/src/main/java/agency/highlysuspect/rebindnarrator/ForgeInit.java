package agency.highlysuspect.rebindnarrator;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;

@Mod("rebind_narrator")
public class ForgeInit {
	public ForgeInit() {
		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true)); //Quality modloader
		DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CoolClientEntrypointEpic::doIt);
	}
	
	public static class CoolClientEntrypointEpic {
		public static void doIt() {
			RebindNarrator.IMPL = new ForgeImpl();
		}
	}
}
