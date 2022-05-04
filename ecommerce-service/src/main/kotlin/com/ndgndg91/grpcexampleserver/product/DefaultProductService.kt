package com.ndgndg91.grpcexampleserver.product

import com.ndgndg91.grpc.stub.product.CreateProductRequest
import com.ndgndg91.grpc.stub.product.Product
import com.ndgndg91.grpc.stub.product.ProductID
import com.ndgndg91.grpc.stub.product.ProductServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class DefaultProductService: ProductServiceGrpc.ProductServiceImplBase() {

    override fun addProduct(request: CreateProductRequest?, responseObserver: StreamObserver<ProductID>?) {
        super.addProduct(request, responseObserver)
    }

    override fun getProduct(request: ProductID?, responseObserver: StreamObserver<Product>?) {
        super.getProduct(request, responseObserver)
    }
}