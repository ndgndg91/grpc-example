package com.ndgndg91.grpcexampleserver

import io.grpc.Status

open class ServiceException(override val message: String, val status: Status): RuntimeException(message)