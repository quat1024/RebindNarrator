package agency.highlysuspect.rebindnarrator;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ForgeImpl extends RebindNarrator {
	@SuppressWarnings("NoTranslation") //mcdev reporting that "key.keyboard.b" has no translation. thanks i guess
	public final KeyMapping NARRATOR_KEY = new KeyMapping(
		"options.narrator",
		KeyConflictContext.UNIVERSAL,
		KeyModifier.CONTROL,
		InputConstants.getKey("key.keyboard.b"),
		"key.categories.misc"
	);
	
	public ForgeImpl() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener((RegisterKeyMappingsEvent e) -> e.register(NARRATOR_KEY));
	}
	
	@Override
	public boolean isCorrectKey(int glfwKeyToken) {
		return glfwKeyToken == NARRATOR_KEY.getKey().getValue(); //getKey is a Forge extension
	}
	
	@Override
	public boolean correctModifiersPressed() {
		return NARRATOR_KEY.getKeyModifier().isActive(KeyConflictContext.UNIVERSAL);
	}
}
