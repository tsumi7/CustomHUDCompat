package we.love.casting.spells.CustomHUDCompat;

import com.minenash.customhud.HudElements.HudElement;
import com.minenash.customhud.mod_compat.CustomHudRegistry;

import fi.dy.masa.malilib.config.IConfigBoolean;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.tweakeroo.config.FeatureToggle;

public class TweakerooCompat {
    private TweakerooCompat() {
        throw new UnsupportedOperationException("should not be instantiated");
    }

	public static void load() {
		CustomHudRegistry.registerElement("tweakeroo", (str) -> {
			int index = str.indexOf(':');
			if (index == -1)
				return null;

			String featureStr = str.substring(index + 1);
			// Support {tweakeroo:flySpeed} as a shortened version of {tweakeroo:TWEAK_FLY_SPEED}.
			if (featureStr != featureStr.toUpperCase())
				featureStr = "TWEAK_" + featureStr.replaceAll("([a-z])([A-Z]+)", "$1_$2").toUpperCase();

			try {
				FeatureToggle feature = FeatureToggle.valueOf(featureStr);
				return new HudElement() {
					@Override public String getString() { return null; }
					@Override public Number getNumber() { return null; }
					@Override public boolean getBoolean() { return feature.getBooleanValue(); }
				};
			} catch (IllegalArgumentException ignored) { return null; }
		});
	}
}