package quaternary.rebindnarrator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.ScreenChatOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = RebindNarrator.MODID, name = RebindNarrator.NAME, version = RebindNarrator.VERSION, clientSideOnly = true)
public class RebindNarrator {
	public static final String MODID = "rebind_narrator";
	public static final String NAME = "Rebind Narrator";
	public static final String VERSION = "1.0.0";
	
	private static KeyBinding bind;
	
	static {
		for(int i=0; i < 100; i++) {
			System.out.println("MOD CLASS LOADED!");
		}
	}
	
	@Mod.EventHandler
	public static void init(FMLInitializationEvent e) {
		bind = new KeyBinding("options.narrator", new IKeyConflictContext() {
			@Override
			public boolean isActive() {
				return !(Minecraft.getMinecraft().currentScreen instanceof GuiControls);
			}
			
			@Override
			public boolean conflicts(IKeyConflictContext other) {
				return false;
			}
		}, KeyModifier.CONTROL, Keyboard.KEY_B, "key.categories.misc");
		
		ClientRegistry.registerKeyBinding(bind);
		
		for(int i=0; i < 100; i++) {
			System.out.println("DEBUG!");
		}
	}
	
	@Mod.EventBusSubscriber
	public static class Events {
		@SubscribeEvent
		public static void input(InputEvent e) {
			if(Keyboard.getEventKeyState() && bind.isActiveAndMatches(Keyboard.getEventKey())) {
				Minecraft mc = Minecraft.getMinecraft();
				mc.gameSettings.setOptionValue(GameSettings.Options.NARRATOR, 1);
				
				if (mc.currentScreen instanceof ScreenChatOptions) {
					((ScreenChatOptions)mc.currentScreen).updateNarratorButton();
				}
			}
		}
	}
	
}
