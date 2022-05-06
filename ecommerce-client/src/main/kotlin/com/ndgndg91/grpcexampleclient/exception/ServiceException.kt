package com.ndgndg91.grpcexampleclient.exception

import io.grpc.Status

open class ServiceException(open val status: Status, override val message: String?): RuntimeException()