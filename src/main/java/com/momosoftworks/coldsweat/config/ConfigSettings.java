package com.momosoftworks.coldsweat.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name="cold_sweat")
public class ConfigSettings implements ConfigData {
    public float MAX_TEMP = 1.7f;
    public float MIN_TEMP = 0.5f;
}