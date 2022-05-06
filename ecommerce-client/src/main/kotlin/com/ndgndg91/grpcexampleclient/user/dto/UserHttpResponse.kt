package com.ndgndg91.grpcexampleclient.user.dto

import java.math.BigInteger

data class UserHttpResponse(
    val id: String,
    val email: String,
    val fullName: String,
    val createdAt: BigInteger
)
