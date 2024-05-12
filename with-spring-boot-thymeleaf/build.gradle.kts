import org.gradle.api.JavaVersion.VERSION_21
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    idea
    kotlin("jvm")
    id("org.springframework.boot") version libs.versions.springBoot
    id("io.spring.dependency-management") version libs.versions.springDependencyManagement
    alias(libs.plugins.jooqCodegen)
    kotlin("plugin.spring") version libs.versions.kotlin
}

sourceSets {
    main {
        java {
            srcDir("build/generated-sources/jooq")
        }
    }
}


java {
    sourceCompatibility = VERSION_21
}

dependencies {
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.jdbc)
    implementation(libs.spring.boot.starter.jooq)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.thymeleaf)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.thymeleaf.layout.dialect)
//    implementation(libs.thymeleaf.extras.springsecurity5)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlinxCoroutines)
    implementation(libs.fasterxml.jackson.module.kotlin)

    implementation(libs.kotlinFaker)

    implementation(libs.h2)
    implementation(libs.flyway.core)
    implementation(libs.jooq.codegen)
    implementation(libs.jooq.meta)
    implementation(libs.jooq.metaExtensions)
    implementation(libs.jooq.core)

    jooqCodegen(libs.jooq.metaExtensions)
    jooqCodegen(libs.jooq.codegen)

    implementation(libs.webjars.locator.core)
    implementation(libs.webjars.bootstrap.core)
    implementation(libs.webjars.bootstrap.icons)
    implementation(libs.webjars.htmx)
    implementation(libs.webjars.hyperscript)

    runtimeOnly(libs.spring.boot.devtools)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.bundles.kotest)
}

tasks.withType<KotlinCompile> {
    dependsOn("jooqCodegen")
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jooq {
    configuration {
        generator {
            target {
                directory = "./build/generated-sources/jooq"
            }
            database {
                name = "org.jooq.meta.extensions.ddl.DDLDatabase"
                properties {
                    property {
                        key = "scripts"
                        value = "src/main/resources/db/migration/V*__*.sql"
                    }
                    property {
                        key = "sort"
                        value = "flyway"
                    }
                    property {
                        key = "recordVersionFields"
                        value = "rec_version"
                    }
                    property {
                        key = "unqualifiedSchema"
                        value = "none"
                    }
                }
            }
        }
    }
}

//jooq {
//    version.set(libs.versions.jooq)
//    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)
//    configurations {
//        create("main") {  // name of the jOOQ configuration
//            jooqConfiguration.apply {
//                generator.apply {
//                    name = "org.jooq.codegen.DefaultGenerator"
//
//                    database.apply {
//                        name = "org.jooq.meta.extensions.ddl.DDLDatabase"
//                        properties = listOf(
//                            Property().apply {
//                                key = "scripts"
//                                value = "src/main/resources/db/migration/V*__*.sql"
//                            },
//                            Property().apply {
//                                key = "sort"
//                                value = "flyway"
//                            },
////                            Property().apply {
////                                key = "unqualifiedSchema"
////                                value = "none"
////                            },
////                            Property().apply {
////                                key = "defaultNameCase"
////                                value = "lower"
////                            },
//                        )
//
//                        recordVersionFields = "rec_version"
//                    }
//                }
//            }
//        }
//    }
//}
