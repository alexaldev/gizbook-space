package io.gizmolab.gizbookspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.gizmolab.gizbookspace.presentation.GizBookApp
import io.gizmolab.gizbookspace.presentation.designsystem.AppTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                GizBookApp()
            }
        }
    }
}
