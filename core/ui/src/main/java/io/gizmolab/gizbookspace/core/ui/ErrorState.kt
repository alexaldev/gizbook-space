package io.gizmolab.gizbookspace.core.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import io.gizmolab.gizbookspace.core.common.DataError
import io.gizmolab.gizbookspace.core.designsystem.AppTheme

/** A failed load: the error's message, and a retry button when [onRetry] is given. */
@Composable
fun ErrorState(
    error: DataError,
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(AppTheme.spacing.large),
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.medium, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(error.messageRes),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
        if (onRetry != null) {
            Button(onClick = onRetry) {
                Text(text = stringResource(R.string.core_ui_retry))
            }
        }
    }
}

@get:StringRes
val DataError.messageRes: Int
    get() =
        when (this) {
            DataError.Network.NO_CONNECTION -> R.string.core_ui_error_no_connection
            DataError.Network.NOT_FOUND -> R.string.core_ui_error_not_found
            DataError.Network.SERVER -> R.string.core_ui_error_server
            DataError.Network.SERIALIZATION,
            DataError.Network.UNKNOWN,
            DataError.Local.UNKNOWN,
            -> R.string.core_ui_error_generic
            DataError.Local.DISK_FULL -> R.string.core_ui_error_disk_full
        }
