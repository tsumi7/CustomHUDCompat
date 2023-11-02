package we.love.casting.spells.CustomHUD;

import java.util.List;

import com.minenash.customhud.HudElements.supplier.BooleanSupplierElement;
import com.minenash.customhud.HudElements.supplier.NumberSupplierElement;
import com.minenash.customhud.HudElements.supplier.SpecialSupplierElement;
import com.minenash.customhud.HudElements.supplier.StringSupplierElement;
import fi.dy.masa.malilib.config.options.*;
import fi.dy.masa.malilib.util.Color4f;
import net.fabricmc.api.ClientModInitializer;

import com.minenash.customhud.mod_compat.CustomHudRegistry;

import fi.dy.masa.malilib.config.IConfigBase;

import static fi.dy.masa.litematica.config.Configs.*;

public class LitematicaCompat implements ClientModInitializer {

	private static final List<List<IConfigBase>> CONFIG_CATS = List.of(Generic.OPTIONS, Colors.OPTIONS, Visuals.OPTIONS, InfoOverlays.OPTIONS);

	@Override
	public void onInitializeClient() {
        CustomHudRegistry.registerElement("litematica", (str) -> {
        	int index = str.indexOf(':');
        	if (index == -1)
        		return null;

			String configName = str.substring(index + 1).replace("_", "");
			IConfigBase config = null;

			outer:
			for (var list : CONFIG_CATS) {
				for (IConfigBase c : list) {
					if (c.getName().equalsIgnoreCase(configName)) {
						config = c;
						break outer;
					}
				}
			}

        	if (config == null)
        		return null;

        	if (config instanceof ConfigString cs)
        		return new StringSupplierElement(cs::getStringValue);
			if (config instanceof ConfigOptionList col)
				return new StringSupplierElement(col::getStringValue);
        	if (config instanceof ConfigColor cc)
        		return new SpecialSupplierElement( SpecialSupplierElement.of(
        				cc::getStringValue,
        				cc::getIntegerValue,
        				() -> cc.getColor() != Color4f.ZERO
        		));
        	if (config instanceof ConfigInteger ci)
        		return new NumberSupplierElement(ci::getIntegerValue, 1, 0);
        	if (config instanceof ConfigDouble cd)
        		return new NumberSupplierElement(cd::getDoubleValue, 1, 1);
        	if (config instanceof ConfigBoolean cb)
        		return new BooleanSupplierElement(cb::getBooleanValue);
        	if (config instanceof ConfigHotkey ch)
        		return new StringSupplierElement(ch::getStringValue);
        	return null;
        });
	}
}