package io.gizmolab.gizbookspace.core.common

/** Why a data operation failed, in terms the UI can turn into a message. */
sealed interface DataError {
    enum class Network : DataError {
        NO_CONNECTION,
        NOT_FOUND,
        SERVER,
        SERIALIZATION,
        UNKNOWN,
    }

    enum class Local : DataError {
        DISK_FULL,
        UNKNOWN,
    }
}
