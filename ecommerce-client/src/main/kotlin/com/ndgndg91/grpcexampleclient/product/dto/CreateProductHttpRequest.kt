package com.ndgndg91.grpcexampleclient.product.dto

import java.math.BigInteger

data class CreateProductHttpRequest(
    val name: String,
    val description: String,
    val price: BigInteger
)
