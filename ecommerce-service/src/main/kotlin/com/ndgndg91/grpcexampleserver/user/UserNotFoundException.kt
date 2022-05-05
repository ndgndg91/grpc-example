package com.ndgndg91.grpcexampleserver.user

import com.ndgndg91.grpcexampleserver.ServiceException
import io.grpc.Status

class UserNotFoundException(override val message: String): ServiceException(message, Status.NOT_FOUND)