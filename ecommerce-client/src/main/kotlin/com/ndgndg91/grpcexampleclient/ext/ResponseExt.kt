package com.ndgndg91.grpcexampleclient.ext

import org.springframework.http.ResponseEntity

fun <T> T.toOkResponseEntity(): ResponseEntity<T> {
    return ResponseEntity.ok(this)
}