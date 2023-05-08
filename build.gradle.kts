plugins {
    id("java")
    id("mod.base-conventions")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "cn.korostudio.mc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io" )
}

dependencies {
    implementation(libs.ignite)
    implementation(libs.mixin)
    implementation("cn.korostudio.mc:hutoolcorecommon:1.1.0")

    compileOnly ("org.projectlombok:lombok:1.18.26")
    annotationProcessor ("org.projectlombok:lombok:1.18.26")

    testCompileOnly ("org.projectlombok:lombok:1.18.26")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.26")

    paperweight.paperDevBundle("1.19.3-R0.1-SNAPSHOT")

    implementation("com.github.LlamaLad7:MixinExtras:0.1.1")
    annotationProcessor("com.github.LlamaLad7:MixinExtras:0.1.1")
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}