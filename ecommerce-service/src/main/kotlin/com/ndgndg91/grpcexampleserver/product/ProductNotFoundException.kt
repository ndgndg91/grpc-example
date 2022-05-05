package com.ndgndg91.grpcexampleserver.product

import com.ndgndg91.grpcexampleserver.ServiceException
import io.grpc.Status

class ProductNotFoundException(override val message: String): ServiceException(message, Status.NOT_FOUND)