package com.example.lintexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ❌ Argument list wrapping violation:
            //    Parameters are split across multiple lines,
            //    but indentation and closing parenthesis are misaligned
            Text(text = "Hello",
            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                maxLines = 1) 
        }
    }
}
