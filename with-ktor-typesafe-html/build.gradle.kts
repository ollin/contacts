import com.github.gradle.node.npm.task.NpxTask

plugins {
    idea
    base
    kotlin("jvm") version libs.versions.kotlin
    kotlin("plugin.serialization") version libs.versions.kotlin
    id("io.ktor.plugin") version libs.versions.ktor
    alias(libs.plugins.nodePlugin)
}

// see gradle.properties
val versionMajor: String by project
val versionMinor: String by project

group = "com.nautsch.contacts"
version = createProjectVersion()

application {
    mainClass.set("com.nautsch.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
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

    testImplementation(libs.ktor.server.tests.jvm)
    testImplementation(libs.bundles.kotest)
}

tasks.withType<Jar> {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            )
        )
    }
}


tasks.register("generateTailwindCSS", NpxTask::class) {
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


fun createProjectVersion(): String {
    var projectVersion = "$versionMajor.$versionMinor-SNAPSHOT"

    // get variables from github action workflow run (CI)
    val githubRef = System.getenv("GITHUB_REF")
    val githubRunNumber = System.getenv("GITHUB_RUN_NUMBER")
    if (githubRef == "refs/heads/main" && githubRunNumber != null) {
        // if run on CI set the version to the github run number
        projectVersion = "$versionMajor.$versionMinor.$githubRunNumber"
    }
    return projectVersion
}