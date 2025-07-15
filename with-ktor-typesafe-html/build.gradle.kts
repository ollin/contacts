import com.github.gradle.node.npm.task.NpxTask
import org.gradle.api.JavaVersion.VERSION_21

plugins {
    idea
    base
    kotlin("jvm")
    kotlin("plugin.serialization") version libs.versions.kotlin
    id("io.ktor.plugin") version libs.versions.ktor
    alias(libs.plugins.nodePlugin)
}


java {
    sourceCompatibility = VERSION_21
}

application {
    mainClass.set("com.nautsch.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.server.htmlbuilder)
    implementation(libs.ktor.server.netty.jvm)
    implementation(libs.ktor.server.resources)
    implementation(libs.ktor.server.webjars.jvm)
    implementation(libs.kotlin.css.jvm)
    implementation(libs.kotlinx.html.jvm)
    implementation(libs.logback.classic)

    implementation(libs.kotlinFaker)

    implementation(libs.webjars.alpinejs)
    implementation(libs.webjars.bootstrap.core)
    implementation(libs.webjars.bootstrap.icons)
    implementation(libs.webjars.htmx)
    implementation(libs.webjars.hyperscript)

    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.bundles.kotest)
}

node {
    // workaround for hasn't merged https://github.com/node-gradle/gradle-node-plugin/pull/328 (2025-07-15)
//    npmCommand = "/opt/homebrew/bin/npm"
    download = true
}


tasks.register("generateTailwindCSS", NpxTask::class) {
    dependsOn("npmInstall")
    command.set("tailwindcss")
    args.set(
        listOf(
//        "-m",
            "-i", "./src/main/frontend/input.css",
            "-o", "./build/resources/main/public/css/output.css",
        )
    )
    inputs.files(
        file("./src/main/frontend/input.css"),
        file("./tailwind.config.js"),
        fileTree("./src/main/kotlin").matching { include("**/*.kt") }
    )
    outputs.files(
        file("./build/resources/main/public/css/output.css")
    )
}

tasks.named("processResources") {
    finalizedBy("generateTailwindCSS")
}

tasks.named("jar") {
    dependsOn("generateTailwindCSS")
}

tasks.named("shadowJar") {
    dependsOn("generateTailwindCSS")
}

tasks.named("test") {
    dependsOn("generateTailwindCSS")
}