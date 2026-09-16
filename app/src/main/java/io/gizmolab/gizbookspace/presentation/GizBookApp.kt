package io.gizmolab.gizbookspace.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.gizmolab.gizbookspace.presentation.components.GizBookBottomBar
import io.gizmolab.gizbookspace.presentation.navigation.GizBookNavHost
import io.gizmolab.gizbookspace.presentation.navigation.TopLevelDestination

@Composable
fun GizBookApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            GizBookBottomBar(
                currentDestination = backStackEntry?.destination,
                onDestinationClick = { destination ->
                    navController.navigate(destination.route) {
                        // Switch tabs rather than stacking them, and let each tab keep
                        // its own back stack across switches.
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        },
    ) { innerPadding ->
        GizBookNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}
