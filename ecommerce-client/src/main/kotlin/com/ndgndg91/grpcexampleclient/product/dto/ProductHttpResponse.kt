package com.ndgndg91.grpcexampleclient.product.dto

import com.ndgndg91.grpc.stub.product.Product
import java.math.BigInteger

data class ProductHttpResponse(
    val product: ProductResponse
) {

    data class ProductResponse(
        val id: String,
        val name: String,
        val description: String,
        val price: BigInteger,
        val createdAt: BigInteger
    )

    constructor(product: Product) : this(
        ProductResponse(
            product.id,
            product.name,
            product.description,
            product.price.toBigInteger(),
            product.createdAt.toBigInteger()
        )
    )
}
