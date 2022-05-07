package com.ndgndg91.grpcexampleclient.ext

import com.ndgndg91.grpcexampleclient.common.ApiError
import com.ndgndg91.grpcexampleclient.common.ApiResponse
import org.springframework.http.ResponseEntity
import java.net.URI

fun <T> T.toOkResponseEntity(): ResponseEntity<ApiResponse<T>> {
    return ResponseEntity.ok(ApiResponse(this, null))
}

fun ApiError.toResponseEntity(): ResponseEntity<ApiResponse<Unit>> {
    return ResponseEntity.status(this.code.toInt()).body(ApiResponse(null, this))
}

fun URI.toCreatedResponseEntity(): ResponseEntity<Unit> {
    return ResponseEntity.created(this).build()
}