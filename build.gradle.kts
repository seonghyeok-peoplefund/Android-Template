import org.gradle.api.tasks.Delete

plugins {
    id("com.android.application") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.5.30" apply false
    id("com.google.dagger.hilt.android") version "2.41" apply false
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
