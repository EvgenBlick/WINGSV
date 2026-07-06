pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://maven.google.com")
            content {
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
            }
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
            content {
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
            }
        }
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.aliyun.com/repository/public")
        }
        maven("https://jitpack.io")

        val seslUser = providers.gradleProperty("seslUser").orNull
        val seslToken = providers.gradleProperty("seslToken").orNull

        if (!seslUser.isNullOrBlank() && !seslToken.isNullOrBlank()) {
            maven {
                url = uri("https://maven.pkg.github.com/tribalfs/sesl-androidx")
                credentials {
                    username = seslUser
                    password = seslToken
                }
                content {
                    includeGroupByRegex("sesl\\.androidx.*")
                }
            }
            maven {
                url = uri("https://maven.pkg.github.com/tribalfs/sesl-material-components-android")
                credentials {
                    username = seslUser
                    password = seslToken
                }
                content {
                    includeGroup("sesl.com.google.android.material")
                }
            }
            maven {
                url = uri("https://maven.pkg.github.com/tribalfs/oneui-design")
                credentials {
                    username = seslUser
                    password = seslToken
                }
                content {
                    includeGroup("io.github.tribalfs")
                }
            }
        }
    }
}

rootProject.name = "WINGS V"
include(":app")
include(":vpnhotspot:bridge")
include(":vpnhotspot:sharing-bridge")
include(":vpnhotspot:upstream-runtime")
include(":vpnhotspot:sharing-runtime")
include(":amneziawg-tunnel")

project(":amneziawg-tunnel").projectDir = file("external/amneziawg-android/tunnel")
 
