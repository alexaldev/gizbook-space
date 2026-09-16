package io.gizmolab.gizbookspace.presentation.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val LightColorScheme =
    lightColorScheme(
        primary = Orange40,
        onPrimary = Orange100,
        primaryContainer = Orange90,
        onPrimaryContainer = Orange10,
        inversePrimary = Orange80,
        secondary = Sand40,
        onSecondary = Sand100,
        secondaryContainer = Sand90,
        onSecondaryContainer = Sand10,
        tertiary = Teal40,
        onTertiary = Teal100,
        tertiaryContainer = Teal90,
        onTertiaryContainer = Teal10,
        error = Red40,
        onError = Color.White,
        errorContainer = Red90,
        onErrorContainer = Red10,
        background = Neutral98,
        onBackground = Neutral10,
        surface = Neutral98,
        onSurface = Neutral10,
        surfaceVariant = NeutralVariant90,
        onSurfaceVariant = NeutralVariant30,
        surfaceTint = Orange40,
        inverseSurface = Neutral20,
        inverseOnSurface = Neutral95,
        surfaceDim = Neutral87,
        surfaceBright = Neutral98,
        surfaceContainerLowest = Neutral100,
        surfaceContainerLow = Neutral96,
        surfaceContainer = Neutral94,
        surfaceContainerHigh = Neutral92,
        surfaceContainerHighest = Neutral90,
        outline = NeutralVariant50,
        outlineVariant = NeutralVariant80,
        scrim = Color.Black,
    )

private val DarkColorScheme =
    darkColorScheme(
        primary = Orange80,
        onPrimary = Orange20,
        primaryContainer = Orange30,
        onPrimaryContainer = Orange90,
        inversePrimary = Orange40,
        secondary = Sand80,
        onSecondary = Sand20,
        secondaryContainer = Sand30,
        onSecondaryContainer = Sand90,
        tertiary = Teal80,
        onTertiary = Teal20,
        tertiaryContainer = Teal30,
        onTertiaryContainer = Teal90,
        error = Red80,
        onError = Red20,
        errorContainer = Red30,
        onErrorContainer = Red90,
        background = Neutral13,
        onBackground = Neutral90,
        surface = Neutral13,
        onSurface = Neutral90,
        surfaceVariant = NeutralVariant30,
        onSurfaceVariant = NeutralVariant80,
        surfaceTint = Orange80,
        inverseSurface = Neutral90,
        inverseOnSurface = Neutral20,
        surfaceDim = Neutral6,
        surfaceBright = Neutral24,
        surfaceContainerLowest = Neutral6,
        surfaceContainerLow = Neutral10,
        surfaceContainer = Neutral17,
        surfaceContainerHigh = Neutral22,
        surfaceContainerHighest = Neutral24,
        outline = NeutralVariant60,
        outlineVariant = NeutralVariant30,
        scrim = Color.Black,
    )

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(LocalSpacing provides Spacing()) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

object AppTheme {
    val spacing: Spacing
        @Composable
        get() = LocalSpacing.current
}
