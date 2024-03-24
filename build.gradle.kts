plugins {
    kotlin("jvm") version libs.versions.kotlin
    id("io.ktor.plugin") version libs.versions.ktor
}

group = "com.nautsch"
version = "0.0.1"

application {
    mainClass.set("com.nautsch.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {

    implementation(libs.ktor.server.htmlbuilder)
    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.server.webjars.jvm)
    implementation(libs.ktor.server.netty.jvm)
    implementation(libs.kotlin.css.jvm)
    implementation(libs.kotlinx.html.jvm)
    implementation(libs.logback.classic)

    implementation(libs.webjars.alpinejs)
    implementation(libs.webjars.bootstrap.core)
    implementation(libs.webjars.bootstrap.icons)
    implementation(libs.webjars.htmx)
    implementation(libs.webjars.hyperscript)


    testImplementation(libs.ktor.server.tests.jvm)
    testImplementation(libs.bundles.kotest)
}
