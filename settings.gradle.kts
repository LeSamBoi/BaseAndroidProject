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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

// TODO: change project name
rootProject.name = "BaseAndroidProject"
include(":app")
include(":domain:wizard")
include(":framework:core")
include(":framework:wizard")
include(":feature:common")
include(":feature:home")
