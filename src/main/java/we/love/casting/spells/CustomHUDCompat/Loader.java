package we.love.casting.spells.CustomHUDCompat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class Loader implements ModInitializer {
	@Override
	public void onInitialize() {
        if (has("tweakeroo")) TweakerooCompat.load();
    }

    private static boolean has(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }
}
