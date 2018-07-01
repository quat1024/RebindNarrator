package quaternary.rebindnarrator;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("Rebind Narrator ASM")
@IFMLLoadingPlugin.TransformerExclusions("quaternary.rebindnarrator")
@IFMLLoadingPlugin.SortingIndex(1337)
public final class LoadingPlugin implements IFMLLoadingPlugin {
	@Override
	public String[] getASMTransformerClass() {
		return new String[]{"quaternary.rebindnarrator.ClassTransformer"};
	}

	@Override
	public String getModContainerClass() {
		return "quaternary.rebindnarrator.RebindNarratorModContainer";
	}

	@Nullable
	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		//No-op
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}
