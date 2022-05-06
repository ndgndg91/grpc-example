package com.ndgndg91.grpcexampleclient.advisor

import com.ndgndg91.grpcexampleclient.exception.ServiceException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ServiceExceptionAdvisor {

    @ExceptionHandler(ServiceException::class)
    fun handleServiceException(e: ServiceException): ResponseEntity<Void> {
        // TODO: response code by status
        return ResponseEntity.notFound().build()
    }
}