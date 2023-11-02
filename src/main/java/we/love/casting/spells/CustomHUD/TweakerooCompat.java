package we.love.casting.spells.CustomHUD;

import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.tweakeroo.config.Hotkeys;
import net.fabricmc.api.ClientModInitializer;
import com.minenash.customhud.mod_compat.CustomHudRegistry;
import fi.dy.masa.tweakeroo.config.FeatureToggle;
import java.util.List;
import static fi.dy.masa.tweakeroo.config.Configs.*;

public class TweakerooCompat implements ClientModInitializer {

	private static final List<List<? extends IConfigBase>> CONFIG_CATS =
			List.of(FeatureToggle.VALUES, Disable.OPTIONS, Generic.OPTIONS, Fixes.OPTIONS, Internal.OPTIONS, Hotkeys.HOTKEY_LIST);

	@Override
	public void onInitializeClient() {
		CustomHudRegistry.registerElement("tweakeroo", (str) -> {
			return MalilibUtils.getOptionElement(CONFIG_CATS, str);
		});
	}
}