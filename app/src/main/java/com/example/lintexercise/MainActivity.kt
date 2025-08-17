package com.example.lintexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {

    // ktlint/detekt가 잡아야 하는 케이스들
    val snake_case_variable = "snake case" // ❌ 프로퍼티 네이밍 규칙 위반 (should be camelCase)
    private val WrongPlacedVariable = "PascalCase" // ❌ 프로퍼티 네이밍 규칙 위반
    private val veryVeryVeryVeryVeryLongVariableNameThatBreaksLineLength =
        "This line is intentionally too long to violate max-line-length" // ❌ 길이 위반

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = greet_user("World")) // ❌ 함수 네이밍 규칙 위반
        }
    }

    fun snake_case_method() { // ❌ 함수 네이밍 규칙 위반 (should be camelCase)
        println("bad method name")
    }
}

// ❌ top-level 함수 네이밍 규칙 위반
fun greet_user(name: String): String {
    return "Hello, $name"
}