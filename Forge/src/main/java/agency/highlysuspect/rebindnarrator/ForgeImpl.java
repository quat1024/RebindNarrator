package agency.highlysuspect.rebindnarrator;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ForgeImpl extends RebindNarrator {
	public final KeyBinding NARRATOR_KEY = new KeyBinding(
		"options.narrator",
		KeyConflictContext.UNIVERSAL,
		KeyModifier.CONTROL,
		InputMappings.getKey("key.keyboard.b"),
		"key.categories.misc"
	);
	
	public ForgeImpl() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener((FMLClientSetupEvent e) -> ClientRegistry.registerKeyBinding(NARRATOR_KEY));
		//FMLJavaModLoadingContext.get().getModEventBus().addListener((RegisterKeyMappingsEvent e) -> e.register(NARRATOR_KEY));
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
