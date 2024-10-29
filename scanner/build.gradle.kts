import org.publicvalue.convention.config.configureIosTargets

plugins {
    id("org.publicvalue.convention.android.library")
    id("org.publicvalue.convention.kotlin.multiplatform.mobile")
    //id("org.publicvalue.convention.centralPublish")
    id("org.publicvalue.convention.compose.multiplatform")
    `maven-publish`
}

description = "Compose Multiplatform QR Code Scanner for Android/iOS"

kotlin {
    configureIosTargets()
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.accompanist.permissions)
                implementation(libs.androidx.camera.camera2)
                implementation(libs.androidx.camera.lifecycle)
                implementation(libs.androidx.camera.view)
                implementation(libs.mlkit.barcode.scanning)
            }
        }

        jvmMain {
            dependencies {
            }
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["kotlin"])
                groupId = "jp.miyayu.easyqrscan"
                artifactId = "easyqrscan"
                version = "0.0.4"
            }
        }
    }
}