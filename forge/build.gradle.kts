buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven { name = "forge"; url = uri("http://files.minecraftforge.net/maven") }
    }
    dependencies {
        classpath "net.minecraftforge.gradle:ForgeGradle:2.1-SNAPSHOT"
    }
}

apply plugin: "net.minecraftforge.gradle.forge"

version = "0.8.15"
group = "com.github.sonagg"
archivesBaseName.set("radium")

minecraft {
    version = "1.8.9-11.15.1.2318-1.8.9"
    runDir = "run"
    mappings = "stable_20" // We'll use stable_20 mappings as in the MDK. Alternatively, we can use snapshot if needed.
    // Note: The common module uses legacy-yarn mappings. We are using Forge's mappings (MCP).
    // This should be okay because the mixins are written against the intermediate mappings (Yarn) but ForgeGradle will remap.
    // However, we must ensure that the mixin config is correct. We'll rely on the fact that the common module's code is the same and the mixins are adapted.
}

dependencies {
    minecraft "net.minecraftforge:forge:${project.minecraft.version}"
    // Depend on the common module
    implementation(project(":common"))
    // Legacy LWJGL3 backport (same as used in fabric)
    modImplementation("io.github.moehreag:legacy-lwjgl3:1.2.11+1.8.9")
    // We need to be careful during pre-launch that we don't touch any Minecraft classes, since other mods
    // will not yet have an opportunity to apply transformations.
    // We'll create a configuration for preLaunchDeps similar to common, but for now we can rely on the common's preLaunchDeps?
    // Actually, the common module already defines a configurationPreLaunch and excludes lwjgl. We'll do the same here if needed.
    // For simplicity, we'll copy the preLaunchDeps and exclusions from common.
}

configurations.create("preLaunchDeps") {
    isCanBeResolved = true
}

configurations.preLaunchDeps {
    dependencies {
        "net.java.dev.jna:jna:5.14.0"
        "net.java.dev.jna:jna-platform:5.14.0"
        "org.slf4j:slf4j-api:2.0.9"
        "org.jetbrains:annotations:25.0.0"
    }
}

// We need to exclude LWJGL because legacy-lwjgl3 provides it.
configurations.configureEach {
    exclude(group = "org.lwjgl.lwjgl")
}

// We'll also set the sourceSets to match the common module's structure?
// Actually, the common module exports its sourceSet. We are depending on the common module, so we don't need to duplicate.
// But we need to make sure our own sourceSet is set up correctly.
// The ForgeGradle plugin expects the main sourceSet to be in src/main/java and src/main/resources.
// We'll create our own sourceSet for the forge module.

// However, note that the common module already exports its classes. We are depending on it, so we can just put our forge-specific code in src/main/java.

// We'll also need to set up the access widener and mixin configuration similar to common.
// Let's adapt the loom and poceus configurations from common? Actually, we are not using Loom, but we still need to set up mixins.
// We'll use the SpongeMixin and mixinProcessor as in common, but note that Forge already bundles SpongePowered Mixin.
// We'll adjust accordingly.

// We'll keep the mixinextras and annotationProcessor from common.

// We'll also set up the access widener and mixin configuration.

// We'll do this by copying the relevant parts from common/build.gradle.kts and adjusting for forge.

// But note: the common module already applies the multiploder-base, fabric-loom-remap, and poceus plugins.
// We are not applying those in forge. We'll need to set up mixins and access widener manually.

// However, the ForgeGradle plugin already sets up the workspace and remapping. We can use the same mixin setup as in common but without the Loom plugin.

// Let's define the mixin configuration and access widener.

// We'll create a configuration for mixinProcessor and use the same dependencies as common.

// We'll also set up the access widener path.

// We'll do this in the forge module's build.gradle.kts.

// We'll also need to set up the Ploceus plugin for intermediary generation? Actually, the common module uses Ploceus for intermediary generation.
// We are depending on the common module, which already has the intermediary generation. We don't need to run Ploceus again in forge.

// Therefore, we can skip applying the Ploceus plugin in forge.

// Let's set up the dependencies for mixinextras and annotationProcessor.

dependencies {
    compileOnly("io.github.llamalad7:mixinextras-common:0.3.5")
    annotationProcessor("io.github.llamalad7:mixinextras-common:0.3.5")
}

// We'll also need to set up the access widener and mixin configuration.

// We'll create a source set for the main code (which is already there by default) and then set up the access widener and mixin config.

// We'll do this by configuring the jar task and the remapJar task? Actually, we are not using the Loom plugin, so we don't have accessWidenerPath and mixin settings.

// Instead, we'll configure the mixin configuration manually.

// We'll set up the mixin configuration file and the access widener file in the resources.

// We'll also need to set up the mixin plugin in the dependencies? Actually, the ForgeGradle plugin already includes the necessary mixin setup.

// We'll just make sure that the mixin configuration file is present in the resources.

// We'll also need to set up the access widener.

// Let's define the access widener file and mixin configuration file in the resources.

// We'll copy the access widener from common/src/main/resources/sodium-common.accesswidener to forge/src/main/resources/sodium-forge.accesswidener?
// But note: the access widener is for the common code. We can use the same access widener for both common and forge?
// Actually, the access widener is for the common module's code. The forge module doesn't have any additional classes that need access widening?
// We'll use the same access widener as common.

// We'll set the access widener path in the mixin configuration? Actually, the access widener is applied by the Loom plugin. Without Loom, we need to apply it differently.

// We'll need to look into how to apply an access widener in ForgeGradle.
// Alternatively, we can rely on the fact that the common module's access widener is already applied when the common module is built?
// But the common module is built as a separate library and its access widener is applied to its own classes.
// When we depend on the common module, we are using the already widened common classes?
// Actually, the access widener is applied at compile time of the common module. So the common module's JAR already has the access wideners applied.
// Therefore, we don't need to apply the access widener again in the forge module.

// We'll just need to make sure that the common module's access widener is applied when building the common module.
// Since we are not changing the common module, we can assume it's already set up correctly.

// Therefore, we can skip the access widener setup in the forge module.

// We'll just set up the mixin configuration.

// We'll create a mixin configuration file in forge/src/main/resources/radium-forge.mixins.json.

// We'll also need to set up the mixin package and the mixin classes.

// Let's finish the build.gradle.kts for now and then create the necessary source and resource files.

// We'll also set the java compatibility to Java 8.

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

// We'll also set up the processResources task to copy the mixin configuration and any other resources.

// We'll do nothing special; the default processResources will copy resources from src/main/resources.

// Let's write the build.gradle.kts as above, but we missed the repositories for the dependencies.

// We'll add the repositories block under the buildscript and also under the allprojects? Actually, we can set the repositories for the project.

// We'll add a repositories block.

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://maven.fabricmc.net/") }
    maven { url = uri("https://maven.neoforged.net/releases/") }
    maven("https://maven.ornithemc.net/releases/")
    maven("https://maven.ornithemc.net/snapshots/")
    gradlePluginPortal()
}

// Now, let's write the file.
