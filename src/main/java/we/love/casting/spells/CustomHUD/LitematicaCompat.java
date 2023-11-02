package we.love.casting.spells.CustomHUD;

import java.util.Optional;
import we.love.casting.spells.CustomHUD.CompatUtils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import com.minenash.customhud.HudElements.HudElement;
import com.minenash.customhud.mod_compat.CustomHudRegistry;

import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.options.ConfigBase;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigDouble;
import fi.dy.masa.malilib.config.options.ConfigInteger;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.litematica.config.Configs;

public class LitematicaCompat implements ModInitializer {
	@Override
	public void onInitialize() {
		CustomHudRegistry.registerElement("litematica", (str) -> {
			int index = str.indexOf(':');
			if (index == -1)
				return null;

			final String featureStrCheck = CompatUtils.toCamelCase(str.substring(index + 1).toLowerCase());
			try {
				Optional<? extends IConfigBase> optional = Configs.Generic.OPTIONS.stream()
		            .filter(element -> element.getName().equals(featureStrCheck))
		            .findFirst();

				if (!optional.isPresent())
					return null;

				return new HudElement() {
					@Override
					public String getString() { 
						if (optional.get() instanceof ConfigString) {
							return ((ConfigString) optional.get()).getStringValue();
						}
						return null;
					}

					@Override
					public Number getNumber() {
						if (optional.get() instanceof ConfigInteger) {
							return ((ConfigInteger) optional.get()).getIntegerValue();
						}
						if (optional.get() instanceof ConfigDouble) {
							return ((ConfigDouble) optional.get()).getDoubleValue();
						}
						return null;
					}

					@Override
					public boolean getBoolean() {
						if (optional.get() instanceof ConfigBoolean) {
							return ((ConfigBoolean) optional.get()).getBooleanValue();
						}
						return false;
					}
				};
			} catch (IllegalArgumentException ignored) { return null; }
		});
	}
}