package we.love.casting.spells.CustomHUD.DynamicFPS;

import com.minenash.customhud.HudElements.supplier.NumberSupplierElement;
import com.minenash.customhud.mod_compat.CustomHudRegistry;
import dynamic_fps.impl.DynamicFPSMod;
import dynamic_fps.impl.PowerState;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import we.love.casting.spells.CustomHUD.util.CommonUtil;

public class Layer implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		if (!CommonUtil.checkAndLog("dynamic_fps")) return;

		CustomHudRegistry.registerElement("dynamic_fps", (str) -> new NumberSupplierElement(() ->
			DynamicFPSMod.powerState() == PowerState.FOCUSED ?
				MinecraftClient.getInstance().getCurrentFps() : DynamicFPSMod.targetFrameRate(), 1, 0)
		);
	}

}