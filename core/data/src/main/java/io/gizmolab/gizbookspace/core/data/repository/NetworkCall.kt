package io.gizmolab.gizbookspace.core.data.repository

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import io.gizmolab.gizbookspace.core.common.DataError
import io.gizmolab.gizbookspace.core.common.DataResult
import io.gizmolab.gizbookspace.core.common.DispatcherProvider
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException

/** Runs a network data source call off the main thread and turns its exceptions into a [DataError]. */
@Suppress("TooGenericExceptionCaught")
internal suspend fun <T> networkCall(
    dispatchers: DispatcherProvider,
    block: suspend () -> T,
): DataResult<T> =
    withContext(dispatchers.io) {
        try {
            Ok(block())
        } catch (e: CancellationException) {
            throw e
        } catch (_: IOException) {
            Err(DataError.Network.NO_CONNECTION)
        } catch (_: SerializationException) {
            Err(DataError.Network.SERIALIZATION)
        } catch (_: Exception) {
            Err(DataError.Network.UNKNOWN)
        }
    }
