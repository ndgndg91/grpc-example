package com.ndgndg91.grpcexampleclient.advisor

import com.ndgndg91.grpcexampleclient.common.ApiError
import com.ndgndg91.grpcexampleclient.common.ApiResponse
import com.ndgndg91.grpcexampleclient.common.toHttpStatusCode
import com.ndgndg91.grpcexampleclient.exception.ServiceException
import com.ndgndg91.grpcexampleclient.ext.toResponseEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ServiceExceptionAdvisor {

    @ExceptionHandler(ServiceException::class)
    fun handleServiceException(e: ServiceException): ResponseEntity<ApiResponse<Unit>> {
        return e.status.toHttpStatusCode()
            .let { ApiError(it.value().toString(), e.message?: it.reasonPhrase) }
            .toResponseEntity()
    }
}