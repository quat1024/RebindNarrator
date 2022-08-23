package agency.highlysuspect.rebindnarrator;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.controls.KeyBindsScreen;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Objects;

public class ForgeImpl extends RebindNarrator {
	public final KeyMapping NARRATOR_KEY = new KeyMapping(
		"options.narrator",
		KeyConflictContext.UNIVERSAL,
		KeyModifier.CONTROL,
		InputConstants.getKey("key.keyboard.b"), //forge :waa:
		"key.categories.misc"
	);
	
	public ForgeImpl() {
		//TODO 1.19: forge moved it to some RegisterKeyMappingsEvent lol
		FMLJavaModLoadingContext.get().getModEventBus().addListener((FMLClientSetupEvent e) -> {
			ClientRegistry.registerKeyBinding(NARRATOR_KEY);
		});
	}
	
	@Override
	public boolean isCorrectKey(int glfwKeyToken) {
		//Forge seems to eagerly set the key binding when you are busy adding modifiers, so rebinding the key makes the narrator spam every frame
		if(Minecraft.getInstance().screen instanceof KeyBindsScreen kScreen) {
			KeyMapping selectedKey = kScreen.selectedKey;
			if(selectedKey != null && Objects.equals(selectedKey.getName(), NARRATOR_KEY.getName())) return false;
		}
		
		return glfwKeyToken == NARRATOR_KEY.getKey().getValue(); //getKey is a Forge extension
	}
	
	@Override
	public boolean correctModifiersPressed() {
		return NARRATOR_KEY.getKeyModifier().isActive(KeyConflictContext.UNIVERSAL);
	}
}
