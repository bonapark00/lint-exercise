// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" // ktlint 플러그인
}

ktlint {
    android.set(true)               // Android 규칙 활성화
    ignoreFailures.set(false)       // 위반 시 빌드 실패
    filter {
        include("**/*.kt")
        exclude("**/*.kts") // Gradle Kotlin DSL 파일 제외 (임시용)
    }
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}
