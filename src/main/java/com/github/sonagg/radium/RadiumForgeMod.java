package com.github.sonagg.radium;

import com.github.sonagg.radium.client.SodiumClientMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod("radium")
public class RadiumForgeMod {
    public RadiumForgeMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register for client setup
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Perform any common setup here
        // For now, we just initialize the client mod
        String version = getClass().getPackage().getImplementationVersion();
        if (version == null) {
            version = "0.8.15"; // fallback
        }
        SodiumClientMod.onInitialization(version);
        // TODO: Load configurations
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        // Perform client-specific setup here
        // For now, we do nothing extra.
    }
}