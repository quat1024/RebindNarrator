package agency.highlysuspect.rebindnarrator;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;

@Mod("rebind_narrator")
public class ForgeInit {
	public ForgeInit() {
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true)); //Quality modloader
		DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CoolClientEntrypointEpic::doIt);
	}
	
	public static class CoolClientEntrypointEpic {
		public static void doIt() {
			System.out.println("CONSTRUCTION");
			RebindNarrator.IMPL = new ForgeImpl();
		}
	}
}
