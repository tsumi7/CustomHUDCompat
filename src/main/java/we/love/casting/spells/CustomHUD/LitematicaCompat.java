package we.love.casting.spells.CustomHUD;

import java.util.List;

import fi.dy.masa.litematica.config.Hotkeys;
import net.fabricmc.api.ClientModInitializer;
import com.minenash.customhud.mod_compat.CustomHudRegistry;
import fi.dy.masa.malilib.config.IConfigBase;
import static fi.dy.masa.litematica.config.Configs.*;

public class LitematicaCompat implements ClientModInitializer {

	private static final List<List<? extends IConfigBase>> CONFIG_CATS =
			List.of(Generic.OPTIONS, Colors.OPTIONS, Visuals.OPTIONS, InfoOverlays.OPTIONS, Hotkeys.HOTKEY_LIST);

	@Override
	public void onInitializeClient() {
        CustomHudRegistry.registerElement("litematica", (str) -> MalilibUtils.getOptionElement(CONFIG_CATS, str));

	}
}