package com.ndgndg91.grpcexampleserver.user

import com.ndgndg91.grpc.stub.user.*
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@GrpcService
class DefaultUserService: UserServiceGrpc.UserServiceImplBase() {
    companion object {
        private val log = LoggerFactory.getLogger(DefaultUserService::class.java)
        // TODO : repository layer
        private val users = ConcurrentHashMap<String, User>()
    }

    override fun create(request: CreateUserRequest, responseObserver: StreamObserver<UserId>) {
        log.info("$request")

        val id = UUID.randomUUID()
        users[id.toString()] = User(id, request.email, request.fullName, LocalDateTime.now().toEpochSecond(ZoneOffset.UTC).toBigInteger())

        val userId = UserId.newBuilder()
            .setId(id.toString())
            .build()

        responseObserver.onNext(userId)
        responseObserver.onCompleted()
    }

    override fun findById(request: UserId, responseObserver: StreamObserver<com.ndgndg91.grpc.stub.user.User>) {
        log.info("$request")
        // TODO : Exception 구체화 및 Advisor
        val user = users[request.id] ?: throw RuntimeException()

        val userResponse = com.ndgndg91.grpc.stub.user.User.newBuilder()
            .setId(user.id.toString())
            .setEmail(user.email)
            .setFullName(user.fullName)
            .setCreatedAt(user.createdAt.toLong())
            .build()
        responseObserver.onNext(userResponse)
        responseObserver.onCompleted()
    }
}