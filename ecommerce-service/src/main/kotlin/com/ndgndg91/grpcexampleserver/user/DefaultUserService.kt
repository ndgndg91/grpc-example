package com.ndgndg91.grpcexampleserver.user

import com.ndgndg91.grpc.stub.user.CreateUserRequest
import com.ndgndg91.grpc.stub.user.User
import com.ndgndg91.grpc.stub.user.UserId
import com.ndgndg91.grpc.stub.user.UserServiceGrpcKt

class DefaultUserService: UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun create(request: CreateUserRequest): UserId {
        return super.create(request)
    }

    override suspend fun findById(request: UserId): User {
        return super.findById(request)
    }
}