package we.love.casting.spells.CustomHUD.LitematicaCompat;

import java.util.List;
import we.love.casting.spells.CustomHUD.MalilibUtils;
import com.minenash.customhud.mod_compat.CustomHudRegistry;
import fi.dy.masa.litematica.config.Hotkeys;
import fi.dy.masa.malilib.config.IConfigBase;
import static fi.dy.masa.litematica.config.Configs.*;

public class Layer {
	private static final List<List<? extends IConfigBase>> CONFIG_CATS =
			List.of(Generic.OPTIONS, Colors.OPTIONS, Visuals.OPTIONS, InfoOverlays.OPTIONS, Hotkeys.HOTKEY_LIST);

	public static void Load() {
        CustomHudRegistry.registerElement("litematica", (str) -> MalilibUtils.getOptionElement(CONFIG_CATS, str));
	}
}