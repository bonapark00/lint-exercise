plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // ktlint 플러그인 선언만 (하위 모듈에서 apply)
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" apply false
}

// 모든 하위 모듈(app 등)에 ktlint 적용 + 공통 설정
subprojects {
    plugins.withId("org.jlleitschuh.gradle.ktlint") {
        afterEvaluate {
            extensions.configure<org.jlleitschuh.gradle.ktlint.KtlintExtension>("ktlint") {
                android.set(true)
                ignoreFailures.set(false)

                reporters {
                    reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
                    reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
                }

                filter {
                    include("**/*.kt")
                    exclude("**/src/test/**")
                    exclude("**/src/androidTest/**") // <-- 실제로 제외되도록 보장
                }
            }
        }
    }
}
