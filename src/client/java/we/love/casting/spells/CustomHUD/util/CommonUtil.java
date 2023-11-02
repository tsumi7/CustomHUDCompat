package we.love.casting.spells.CustomHUD.util;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonUtil {
    public static final Logger LOGGER = LogManager.getLogger("CustomHudCompat");

    public static boolean checkAndLog(String modid) {
        boolean loaded = FabricLoader.getInstance().isModLoaded(modid);
        LOGGER.info((loaded? "Loaded" : "Skipped") + " CustomHud Compatibility for " + modid);
        return loaded;
    }

}
