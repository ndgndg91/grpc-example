package com.ndgndg91.grpcexampleserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcExampleServerApplication

fun main(args: Array<String>) {
    runApplication<GrpcExampleServerApplication>(*args)
}
