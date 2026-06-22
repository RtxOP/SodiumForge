package com.github.sonagg.radium;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

/**
 * Bootstrap Mixin for Forge 1.8.9. Forge <1.14 does not bundle Mixin,
 * so this class is registered via the JAR manifest ({@code FMLCorePlugin})
 * to be invoked by FML before any mixin classes are touched.
 *
 * <p>Reference: <a href="https://github.com/manuthebyte/template-forge-mixin-1.8.9">manuthebyte/template-forge-mixin-1.8.9</a>.
 */
@IFMLLoadingPlugin.Name("Radium-MixinLoader")
public class MixinLoader implements IFMLLoadingPlugin {

    /** Matches the manifest's {@code MixinConfigs} entry. */
    private static final String MIXIN_CONFIG = "radium-forge.mixins.json";

    public MixinLoader() {
        MixinBootstrap.init();
        Mixins.addConfiguration(MIXIN_CONFIG);
        MixinEnvironment.getDefaultEnvironment()
                .setSide(MixinEnvironment.Side.CLIENT);
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }
}
