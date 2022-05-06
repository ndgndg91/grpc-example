package com.ndgndg91.grpcexampleclient.user.dto

data class CreateUserHttpRequest(
    val email: String,
    val fullName: String
)