package com.ndgndg91.grpcexampleserver.product

import java.math.BigInteger
import java.util.UUID

data class Product(
    val id: UUID,
    val name: String,
    val description: String,
    val price: BigInteger,
    val createdAt: BigInteger
)