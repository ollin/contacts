plugins {
    idea
    base

    kotlin("jvm") version libs.versions.kotlin apply false
}

// see gradle.properties
val versionMajor: String by project
val versionMinor: String by project

allprojects {
    version = createProjectVersion()
    group = "com.nautsch.contacts"

    tasks.withType<Jar> {
        duplicatesStrategy = DuplicatesStrategy.WARN

        manifest {
            attributes(
                mapOf(
                    "Implementation-Title" to project.name,
                    "Implementation-Version" to project.version
                )
            )
        }
    }
    repositories {
        mavenCentral()
    }

}

idea {
    module.isDownloadJavadoc = true
    module.isDownloadSources = true
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