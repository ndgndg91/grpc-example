package com.ndgndg91.grpcexampleserver

import io.grpc.StatusRuntimeException
import net.devh.boot.grpc.server.advice.GrpcAdvice
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler
import org.slf4j.LoggerFactory

@GrpcAdvice
class ServiceExceptionAdvisor {
    companion object {
        private val log = LoggerFactory.getLogger(ServiceExceptionAdvisor::class.java)
    }

    @GrpcExceptionHandler(ServiceException::class)
    fun handleServiceException(e: ServiceException): StatusRuntimeException {
        log.info("$e")

        return e.status
            .withDescription(e.message)
            .withCause(e)
            .asRuntimeException()
    }
}