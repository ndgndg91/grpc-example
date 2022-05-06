package com.ndgndg91.grpcexampleserver.product

import com.ndgndg91.grpc.stub.product.CreateProductRequest
import com.ndgndg91.grpc.stub.product.Product
import com.ndgndg91.grpc.stub.product.ProductId
import com.ndgndg91.grpc.stub.product.ProductServiceGrpc
import com.ndgndg91.grpcexampleserver.user.DefaultUserService
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@GrpcService
class DefaultProductService: ProductServiceGrpc.ProductServiceImplBase() {companion object {
    private val log = LoggerFactory.getLogger(DefaultUserService::class.java)
    // TODO : repository layer
    private val products = ConcurrentHashMap<String, com.ndgndg91.grpcexampleserver.product.Product>()
}

    override fun createProduct(request: CreateProductRequest, responseObserver: StreamObserver<ProductId>) {
        log.info("$request")
        val id = UUID.randomUUID()

        products[id.toString()] = Product(
            id,
            request.name,
            request.description,
            request.price.toBigInteger(),
            LocalDateTime.now().toEpochSecond(ZoneOffset.UTC).toBigInteger()
        )

        val productID = ProductId.newBuilder()
            .setId(id.toString())
            .build()
        responseObserver.onNext(productID)
        responseObserver.onCompleted()
    }

    override fun findById(request: ProductId, responseObserver: StreamObserver<Product>) {
        log.info("$request")

        val product = products[request.id]?: throw ProductNotFoundException("can not find product by ${request.id}")

        val response = Product.newBuilder()
            .setId(product.id.toString())
            .setName(product.name)
            .setDescription(product.description)
            .setPrice(product.price.toLong())
            .setCreatedAt(product.createdAt.toLong())
            .build()

        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}