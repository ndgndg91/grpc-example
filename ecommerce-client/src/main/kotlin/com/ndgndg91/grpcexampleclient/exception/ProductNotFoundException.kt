package com.ndgndg91.grpcexampleclient.exception

import io.grpc.Status

class ProductNotFoundException(override val status: Status, override val message: String?) : ServiceException(status, message)