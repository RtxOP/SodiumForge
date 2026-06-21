package com.github.sonagg.radium;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.caffeinemc.mods.sodium.client.SodiumClientMod;

@Mod(modid = "radium", version = RadiumForgeMod.VERSION, name = RadiumForgeMod.NAME)
public class RadiumForgeMod {
    public static final String MODID = "radium";
    public static final String NAME = "Radium";
    public static final String VERSION = "0.8.15";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        SodiumClientMod.onInitialization(VERSION);
    }
}
