package we.love.casting.spells.CustomHUD;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import com.minenash.customhud.mod_compat.CustomHudRegistry;
import com.minenash.customhud.HudElements.supplier.BooleanSupplierElement;

import fi.dy.masa.malilib.config.IConfigBoolean;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.tweakeroo.config.FeatureToggle;

public class TweakerooCompat implements ModInitializer {
	@Override
	public void onInitialize() {
		CustomHudRegistry.registerElement("tweakeroo", (str) -> {
			int index = str.indexOf(':');
			if (index == -1)
				return null;

			String featureStr = str.substring(index + 1).toUpperCase();
			try {
				FeatureToggle feature = FeatureToggle.valueOf(featureStr);
				return new BooleanSupplierElement(() -> feature.getBooleanValue());
			} catch (IllegalArgumentException ignored) { return null; }
		});
	}
}