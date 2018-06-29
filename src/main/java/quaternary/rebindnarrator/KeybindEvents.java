package quaternary.rebindnarrator;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.ScreenChatOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public final class KeybindEvents {
	private KeyBinding keyBinding;

	// See: RebindNarrator#registerBus
	@Subscribe
	public void onInitialization(FMLInitializationEvent event) {
		// Register this instance to Forge's event bus
		MinecraftForge.EVENT_BUS.register(this);

		keyBinding = new KeyBinding("options.narrator", new IKeyConflictContext() {
			@Override
			public boolean isActive() {
				return !(Minecraft.getMinecraft().currentScreen instanceof GuiControls);
			}

			@Override
			public boolean conflicts(IKeyConflictContext other) {
				return false;
			}
		}, KeyModifier.CONTROL, Keyboard.KEY_B, "key.categories.misc");

		ClientRegistry.registerKeyBinding(keyBinding);
	}

	@SubscribeEvent
	public void onInput(InputEvent event) {
		if (Keyboard.getEventKeyState() && keyBinding.isActiveAndMatches(Keyboard.getEventKey())) {
			final Minecraft mc = Minecraft.getMinecraft();

			mc.gameSettings.setOptionValue(GameSettings.Options.NARRATOR, 1);

			if (mc.currentScreen instanceof ScreenChatOptions) {
				((ScreenChatOptions) mc.currentScreen).updateNarratorButton();
			}
		}
	}
}
