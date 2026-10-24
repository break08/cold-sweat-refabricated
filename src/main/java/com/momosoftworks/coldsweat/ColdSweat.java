package com.momosoftworks.coldsweat;

import com.momosoftworks.coldsweat.config.ConfigSettings;
import com.momosoftworks.coldsweat.core.init.EdibleInit;
import com.momosoftworks.coldsweat.core.init.ModBlocks;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class ColdSweat implements ModInitializer {
    public static final String MOD_ID = "cold_sweat";

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        EdibleInit.onEdiblesRegister();

        // Cloth Config API
        AutoConfig.register(ConfigSettings.class, GsonConfigSerializer::new);
    }
}
