package com.ndgndg91.grpcexampleclient.exception

import io.grpc.Status

class UserNotFoundException(override val status: Status, override val message: String?) : ServiceException(status, message)
