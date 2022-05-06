package com.ndgndg91.grpcexampleclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcExampleClientApplication

fun main(args: Array<String>) {
    runApplication<GrpcExampleClientApplication>(*args)
}