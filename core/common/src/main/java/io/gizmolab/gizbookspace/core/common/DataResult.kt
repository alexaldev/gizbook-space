package io.gizmolab.gizbookspace.core.common

import com.github.michaelbull.result.Result

/** The return type of every repository call that can fail. */
typealias DataResult<T> = Result<T, DataError>
