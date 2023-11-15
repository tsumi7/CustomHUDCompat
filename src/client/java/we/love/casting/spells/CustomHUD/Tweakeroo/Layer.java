package we.love.casting.spells.CustomHUD.Tweakeroo;

import java.util.List;

import net.fabricmc.api.ClientModInitializer;
import we.love.casting.spells.CustomHUD.util.CommonUtil;
import we.love.casting.spells.CustomHUD.util.MalilibUtils;
import com.minenash.customhud.mod_compat.CustomHudRegistry;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.tweakeroo.config.Hotkeys;
import fi.dy.masa.tweakeroo.config.FeatureToggle;
import static fi.dy.masa.tweakeroo.config.Configs.*;

public class Layer implements ClientModInitializer {
	private static final List<List<? extends IConfigBase>> CONFIG_CATS =
			List.of(FeatureToggle.VALUES, Disable.OPTIONS, Generic.OPTIONS, Fixes.OPTIONS, Internal.OPTIONS, Hotkeys.HOTKEY_LIST);

	@Override
	public void onInitializeClient() {
		if (!CommonUtil.checkAndLog("tweakeroo")) return;
		CustomHudRegistry.registerElement("tweakeroo", (str) -> MalilibUtils.getOptionElement(CONFIG_CATS, str));
	}
}