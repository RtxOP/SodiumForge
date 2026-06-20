package com.github.sonagg.radium;

import com.github.sonagg.radium.client.SodiumClientMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Objects;

@Mod("radium")
public class SodiumForgeMod {
    public SodiumForgeMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for bus events (such as lifecycle events)
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Perform any common setup here
        // For now, we just collect config entry points and initialize the client mod
        // We'll need to adapt the config loading from Fabric to Forge.
        // For simplicity, we'll skip config loading for now and just initialize the client mod.
        // We'll need to get the mod version.
        String version = getClass().getPackage().getImplementationVersion();
        if (version == null) {
            version = "0.8.15"; // fallback
        }
        SodiumClientMod.onInitialization(version);
        // TODO: Register configs early (like ConfigManager.registerConfigsEarly())
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        // Perform client-specific setup here
        // We already did the initialization in common setup, but we can also do client-specific things if needed.
        // For now, we do nothing extra.
    }
}