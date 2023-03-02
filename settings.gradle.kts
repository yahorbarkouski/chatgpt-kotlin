apply(from = File(settingsDir, "gradle/repositoriesSettings.gradle.kts"))

rootProject.name = "chatgpt-kotlin"

include(
    "chatgpt-core",
    "chatgpt-spring-boot-starter",
//    "notion-toggler-micronaut"
)
