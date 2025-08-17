plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // ktlint 플러그인 선언만 (하위 모듈에서 apply)
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" apply false
}

// 모든 하위 모듈(app 등)에 ktlint 적용 + 공통 설정
subprojects {
    plugins.apply("org.jlleitschuh.gradle.ktlint")

    extensions.configure<org.jlleitschuh.gradle.ktlint.KtlintExtension>("ktlint") {
        android.set(true)
        ignoreFailures.set(false)

        // 보고서 포맷
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        }

        // 검사 대상/제외 경로 (대소문자 주의: androidTest)
        filter {
            include("**/*.kt")
            exclude("**/*.kts")            // Gradle Kotlin DSL은 제외(원하면 지우세요)
            exclude("**/src/test/**")
            exclude("**/src/androidTest/**")
        }
    }
}
