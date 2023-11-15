package we.love.casting.spells.CustomHUD.Litematica;

import java.util.List;

import net.fabricmc.api.ClientModInitializer;
import we.love.casting.spells.CustomHUD.util.CommonUtil;
import we.love.casting.spells.CustomHUD.util.MalilibUtils;
import com.minenash.customhud.mod_compat.CustomHudRegistry;
import fi.dy.masa.litematica.config.Hotkeys;
import fi.dy.masa.malilib.config.IConfigBase;
import static fi.dy.masa.litematica.config.Configs.*;

public class Layer implements ClientModInitializer {
	private static final List<List<? extends IConfigBase>> CONFIG_CATS =
			List.of(Generic.OPTIONS, Colors.OPTIONS, Visuals.OPTIONS, InfoOverlays.OPTIONS, Hotkeys.HOTKEY_LIST);

	@Override
	public void onInitializeClient() {
		if (!CommonUtil.checkAndLog("litematica")) return;
		CustomHudRegistry.registerElement("litematica", (str) -> MalilibUtils.getOptionElement(CONFIG_CATS, str));
	}

}