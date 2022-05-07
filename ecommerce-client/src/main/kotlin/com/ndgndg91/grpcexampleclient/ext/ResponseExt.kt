package com.ndgndg91.grpcexampleclient.ext

import org.springframework.http.ResponseEntity
import java.net.URI

fun <T> T.toOkResponseEntity(): ResponseEntity<T> {
    return ResponseEntity.ok(this)
}

fun URI.toCreatedResponseEntity(): ResponseEntity<Unit> {
    return ResponseEntity.created(this).build()
}