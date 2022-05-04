package com.ndgndg91.grpcexampleserver.user

import java.math.BigInteger
import java.util.UUID

data class User(
    val id: UUID,
    val email: String,
    val fullName: String,
    val createdAt: BigInteger
)