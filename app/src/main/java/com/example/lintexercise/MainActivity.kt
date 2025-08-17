package com.example.lintexercise

// Import issues below are intentional for ktlint:
import androidx.compose.material3.Text          // <- out of order (will be sorted)
import androidx.activity.compose.setContent     // <- out of order (will be sorted)
import kotlin.collections.*                     // <- wildcard import (ktlint: no-wildcard-imports)
import androidx.activity.ComponentActivity      // <- out of order (will be sorted)
import androidx.compose.runtime.Composable      // <- unused import (ktlint: no-unused-imports)
import android.os.Bundle                        // <- out of order (will be sorted)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {  
        super.onCreate(savedInstanceState)        
        setContent {
            // Unnecessary string template braces + extra semicolon
            Text(text = greeting("${"World"}"));    
        } 
    }

    // Spacing around colon, unnecessary semicolon, and indentation issues inside body
    private fun greeting(name : String) : String {    
        val msg = "Hello, ${name}";   
        return msg
    }   

    // Extra blank line before the closing brace below is intentional (ktlint: no-consecutive-blank-lines)

}
