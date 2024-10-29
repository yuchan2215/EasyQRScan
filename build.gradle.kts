plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kmp) apply false
    alias(libs.plugins.dokka)
    `maven-publish`
}

subprojects {
    group = "io.github.kalinjul.easyqrscan"
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "jp.miyayu.easyqrscan"
                artifactId = "easyqrscan"
                version = "0.0.3"
            }
        }
    }
}
