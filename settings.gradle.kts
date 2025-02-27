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

rootProject.name = "Effective Mobile Practice"
include(":app")
include(":feature:login")
include(":core:network")
include(":core:database")
include(":feature:jobs")
include(":feature:favourite_vacancies")
include(":core:ui")
include(":core:util")
include(":core:constant")
include(":core:di")
