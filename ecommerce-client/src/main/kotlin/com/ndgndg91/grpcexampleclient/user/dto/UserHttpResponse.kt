package com.ndgndg91.grpcexampleclient.user.dto

import com.ndgndg91.grpc.stub.user.User
import java.math.BigInteger

data class UserHttpResponse(
    val user: UserResponse
) {
    data class UserResponse(
        val id: String,
        val email: String,
        val fullName: String,
        val createdAt: BigInteger
    )

    constructor(user: User): this(
        UserResponse(
            user.id,
            user.email,
            user.fullName,
            user.createdAt.toBigInteger()
        )
    )
}
