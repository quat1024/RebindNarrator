package quaternary.rebindnarrator.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("Rebind Narrator ASM")
@IFMLLoadingPlugin.TransformerExclusions("quaternary.rebindnarrator.asm")
@IFMLLoadingPlugin.SortingIndex(1337)
public final class LoadingPlugin implements IFMLLoadingPlugin {
	@Override
	public String[] getASMTransformerClass() {
		return new String[]{"quaternary.rebindnarrator.asm.ClassTransformer"};
	}

	@Override
	public String getModContainerClass() {
		return "quaternary.rebindnarrator.RebindNarrator";
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
