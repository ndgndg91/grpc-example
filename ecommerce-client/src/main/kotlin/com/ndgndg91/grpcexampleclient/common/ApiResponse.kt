package com.ndgndg91.grpcexampleclient.common

import com.fasterxml.jackson.annotation.JsonInclude
import io.grpc.Status
import org.springframework.http.HttpStatus
import java.math.BigInteger
import java.time.LocalDateTime
import java.time.ZoneOffset

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse<T>(
    val data: T?,
    val error: ApiError?,
    val meta: ApiMeta = ApiMeta(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC).toBigInteger())
)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiError(
    val code: String,
    val message: String
)

data class ApiMeta(
    val timestamp: BigInteger
)

fun Status.toHttpStatusCode(): HttpStatus {
    return when(this.code) {
        Status.OK.code -> HttpStatus.OK
        Status.NOT_FOUND.code -> HttpStatus.NOT_FOUND
        Status.PERMISSION_DENIED.code -> HttpStatus.FORBIDDEN
        Status.INVALID_ARGUMENT.code -> HttpStatus.BAD_REQUEST
        Status.ALREADY_EXISTS.code -> HttpStatus.UNPROCESSABLE_ENTITY
        Status.UNAUTHENTICATED.code -> HttpStatus.UNAUTHORIZED
        else -> HttpStatus.INTERNAL_SERVER_ERROR
    }
}