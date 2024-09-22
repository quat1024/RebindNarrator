package agency.highlysuspect.rebindnarrator;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;

public class ForgeImpl extends RebindNarrator {
	@SuppressWarnings("NoTranslation") //mcdev reporting that "key.keyboard.b" has no translation. thanks i guess
	public final KeyMapping NARRATOR_KEY = new KeyMapping(
		"options.narrator",
		KeyConflictContext.UNIVERSAL,
		KeyModifier.CONTROL,
		InputConstants.getKey("key.keyboard.b"),
		"key.categories.misc"
	);
	
	public ForgeImpl(IEventBus modBus) {
		modBus.addListener(this::onRegisterKeyMappings);
	}
	
	private void onRegisterKeyMappings(RegisterKeyMappingsEvent e) {
		e.register(NARRATOR_KEY);
	}
	
	@Override
	public boolean isCorrectKey(int glfwKeyToken) {
		return glfwKeyToken == NARRATOR_KEY.getKey().getValue(); //getKey is a Neoforge extension
	}
	
	@Override
	public boolean correctModifiersPressed() {
		return NARRATOR_KEY.getKeyModifier().isActive(KeyConflictContext.UNIVERSAL);
	}
}
