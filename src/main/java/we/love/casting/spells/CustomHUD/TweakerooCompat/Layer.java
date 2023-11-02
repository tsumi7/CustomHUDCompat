package we.love.casting.spells.CustomHUD.TweakerooCompat;

import java.util.List;
import com.minenash.customhud.mod_compat.CustomHudRegistry;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.tweakeroo.config.Hotkeys;
import fi.dy.masa.tweakeroo.config.FeatureToggle;
import static fi.dy.masa.tweakeroo.config.Configs.*;

public class Layer {
	private static final List<List<? extends IConfigBase>> CONFIG_CATS =
			List.of(FeatureToggle.VALUES, Disable.OPTIONS, Generic.OPTIONS, Fixes.OPTIONS, Internal.OPTIONS, Hotkeys.HOTKEY_LIST);

	public static void Load() {
		CustomHudRegistry.registerElement("tweakeroo", (str) -> {
			return MalilibUtils.getOptionElement(CONFIG_CATS, str);
		});
	}
}