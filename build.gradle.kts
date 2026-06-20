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
    mappings = "stable_20"
}

dependencies {
    minecraft "net.minecraftforge:forge:${project.minecraft.version}"
    // Legacy LWJGL3 backport (same as used in Radium/Fabric)
    modImplementation("io.github.moehreag:legacy-lwjgl3:1.2.11+1.8.9")
    // We need to be careful during pre-launch that we don't touch any Minecraft classes
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
}

// Exclude LWJGL because legacy-lwjgl3 provides it
configurations.configureEach {
    exclude(group = "org.lwjgl.lwjgl")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

// Process resources to handle version substitution
processResources {
    from(sourceSets.main.resources.srcDirs) {
        include 'mcmod.info'
        expand 'version': project.version, 'mcversion': project.minecraft.version
    }
    from(sourceSets.main.resources.srcDirs) {
        exclude 'mcmod.info'
    }
}