package we.love.casting.spells.CustomHUD.util;

import com.google.common.collect.ImmutableList;
import com.minenash.customhud.HudElements.HudElement;
import com.minenash.customhud.HudElements.supplier.BooleanSupplierElement;
import com.minenash.customhud.HudElements.supplier.NumberSupplierElement;
import com.minenash.customhud.HudElements.supplier.SpecialSupplierElement;
import com.minenash.customhud.HudElements.supplier.StringSupplierElement;
import fi.dy.masa.malilib.config.*;
import fi.dy.masa.malilib.config.options.*;
import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.interfaces.IStringValue;
import fi.dy.masa.malilib.util.Color4f;

import java.util.List;

public class MalilibUtils {

    public static HudElement getOptionElement(List<List<? extends IConfigBase>> options, String str) {
        int index = str.indexOf(':');
        if (index == -1)
            return null;

        String configName = str.substring(index + 1).replace("_", "");
        IConfigBase config = null;

        outer:
        for (List<? extends IConfigBase> list : options) {
            for (IConfigBase c : list) {
                if (c.getName().equalsIgnoreCase(configName)) {
                    config = c;
                    break outer;
                }
            }
        }

        if (config == null)
            return null;
        if (config instanceof ConfigColor cc)
            return new SpecialSupplierElement( SpecialSupplierElement.of(
                    cc::getStringValue,
                    cc::getIntegerValue,
                    () -> cc.getColor() != Color4f.ZERO
            ));
        if (config instanceof IConfigInteger ci)
            return new NumberSupplierElement(ci::getIntegerValue, 1, 0);
        if (config instanceof IConfigDouble cd)
            return new NumberSupplierElement(cd::getDoubleValue, 1, 1);
        if (config instanceof IConfigBoolean cb)
            return new BooleanSupplierElement(cb::getBooleanValue);
        if (config instanceof IConfigOptionList col)
            return new StringSupplierElement(() -> col.getOptionListValue().getDisplayName());
        if (config instanceof IStringValue cs)
            return new StringSupplierElement(cs::getStringValue);
        return null;
    }

}
