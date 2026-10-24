package com.momosoftworks.coldsweat.core.init;

import com.momosoftworks.coldsweat.api.event.core.registry.EdiblesRegisterEvent;
import com.momosoftworks.coldsweat.common.entity.data.edible.*;

public class EdibleInit
{

    public static void onEdiblesRegister()
    {
        EdiblesRegisterEvent.registerEdible(new HotBiomeEdible());
        EdiblesRegisterEvent.registerEdible(new ColdBiomeEdible());
        EdiblesRegisterEvent.registerEdible(new HumidBiomeEdible());
        EdiblesRegisterEvent.registerEdible(new TamingEdible());
    }

}
