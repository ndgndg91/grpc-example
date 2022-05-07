package com.ndgndg91.grpcexampleclient.config

import com.ndgndg91.grpc.stub.product.CreateProductRequest
import com.ndgndg91.grpc.stub.product.Product
import com.ndgndg91.grpc.stub.product.ProductId
import com.ndgndg91.grpc.stub.product.ProductServiceGrpcKt
import com.ndgndg91.grpc.stub.user.CreateUserRequest
import com.ndgndg91.grpc.stub.user.User
import com.ndgndg91.grpc.stub.user.UserId
import com.ndgndg91.grpc.stub.user.UserServiceGrpcKt
import com.ndgndg91.grpcexampleclient.exception.ProductNotFoundException
import com.ndgndg91.grpcexampleclient.exception.UserNotFoundException
import io.grpc.ManagedChannel
import io.grpc.StatusException
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.math.BigInteger
import java.util.concurrent.TimeUnit

class EcommerceClient(private val channel: ManagedChannel): Closeable {
    companion object {
        private val log = LoggerFactory.getLogger(EcommerceClient::class.java)
    }

    private val productStub: ProductServiceGrpcKt.ProductServiceCoroutineStub by lazy {
        ProductServiceGrpcKt.ProductServiceCoroutineStub(
            channel
        )
    }
    private val userStub: UserServiceGrpcKt.UserServiceCoroutineStub by lazy {
        UserServiceGrpcKt.UserServiceCoroutineStub(
            channel
        )
    }

    suspend fun createUser(email: String, fullName: String): UserId {
        val request = CreateUserRequest.newBuilder()
            .setEmail(email).setFullName(fullName).build()
        return userStub.create(request)
    }

    suspend fun findUserById(id: String): User {
        try {
            val userId = UserId.newBuilder().setId(id).build()
            return userStub.findById(userId)
        } catch (e: StatusException) {
            log.error("failed to find user by $id", e)
            throw UserNotFoundException(e.status, e.message)
        }

    }

    suspend fun createProduct(name: String, description: String, price: BigInteger): ProductId {
        val request = CreateProductRequest.newBuilder()
            .setName(name)
            .setDescription(description)
            .setPrice(price.toLong())
            .build()

        return productStub.createProduct(request)
    }

    suspend fun findProductById(id: String): Product {
        try {
            val productId = ProductId.newBuilder().setId(id).build()
            return productStub.findById(productId)
        } catch (e: StatusException) {
            log.error("failed to find product by $id", e)
            throw ProductNotFoundException(e.status, e.message)
        }
    }


    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

}