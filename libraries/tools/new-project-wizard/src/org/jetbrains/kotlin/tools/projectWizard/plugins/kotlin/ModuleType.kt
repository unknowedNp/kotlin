package org.jetbrains.kotlin.tools.projectWizard.plugins.kotlin

import org.jetbrains.kotlin.tools.projectWizard.ir.buildsystem.StdlibType

@Suppress("EnumEntryName")
enum class ModuleType(val projectTypeName: String) {
    jvm("Kotlin/JVM"),
    js("Kotlin/JS"),
    native("Kotlin/Native"),
    common("Common")

    ;

    companion object {
        val ALL = setOf(jvm, js, native, common)
    }
}

@Suppress("EnumEntryName", "Unused", "SpellCheckingInspection")
enum class ModuleSubType(val moduleType: ModuleType) {
    jvm(ModuleType.jvm),
    js(ModuleType.js),
    android(ModuleType.jvm), androidNativeArm32(ModuleType.native), androidNativeArm64(ModuleType.native),
    iosArm32(ModuleType.native), iosArm64(ModuleType.native), iosX64(ModuleType.native),
    linuxArm32Hfp(ModuleType.native), linuxMips32(ModuleType.native), linuxMipsel32(ModuleType.native),
    linuxX64(ModuleType.native),
    macosX64(ModuleType.native),
    mingwX64(ModuleType.native), mingwX86(ModuleType.native),
    common(ModuleType.common)
}

fun ModuleType.correspondingStdlib(): StdlibType? = when (this) {
    ModuleType.jvm -> StdlibType.StdlibJdk8
    ModuleType.js -> StdlibType.StdlibJs
    ModuleType.native -> null
    ModuleType.common -> StdlibType.StdlibCommon
}

