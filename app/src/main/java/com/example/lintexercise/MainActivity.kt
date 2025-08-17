package com.example.lintexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {

    // ❌ Line 9: Class body should not start with blank line

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // ❌ Line 16: Missing newline after "("
            // ❌ Line 16: Argument should be on a separate line (unless all arguments can fit a single line)
            Text(text = "Hello", // ← starts arguments on same line as function call
                style = MaterialTheme.typography.bodyLarge, // ❌ Line 17: Unexpected indentation (12) (should be 16)
                maxLines = 1) // ❌ Line 18:
                              //     - Missing newline before ")"
                              //     - Missing trailing comma before ")"
                              //     - Trailing space(s)

            // ✅ CORRECT formatting
            Text(
                text = "Hello",
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
            )
        }
    }
}
