package we.love.casting.spells.CustomHUD;

import net.fabricmc.api.ModInitializer;

import com.minenash.customhud.HudElements.HudElement;
import com.minenash.customhud.mod_compat.CustomHudRegistry;

public class TestCompat implements ModInitializer {
	@Override
	public void onInitialize() {
		CustomHudRegistry.registerElement("test", (str) -> {
			int index = str.indexOf(':');
			if (index == -1)
				return null;

			final String featureStr = str.substring(index + 1);
			final String featureStrCheck = featureStr;

			try {
				return new HudElement() {
					@Override
					public String getString() { 
						return featureStr;
					}
					@Override public Number getNumber() { return -1.0f; }
					@Override public boolean getBoolean() { return true; }
				};
			} catch (IllegalArgumentException ignored) { return null; }
		});
	}
}