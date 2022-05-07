package com.ndgndg91.grpcexampleclient.product

import com.ndgndg91.grpcexampleclient.common.ApiResponse
import com.ndgndg91.grpcexampleclient.config.EcommerceClient
import com.ndgndg91.grpcexampleclient.ext.toCreatedResponseEntity
import com.ndgndg91.grpcexampleclient.ext.toOkResponseEntity
import com.ndgndg91.grpcexampleclient.product.dto.CreateProductHttpRequest
import com.ndgndg91.grpcexampleclient.product.dto.ProductHttpResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class ProductController(private val ecommerceClient: EcommerceClient){

    @PostMapping("/api/products")
    suspend fun createProduct(@RequestBody request: CreateProductHttpRequest): ResponseEntity<Unit> {
        return ecommerceClient.createProduct(request.name, request.description, request.price).let {
            URI.create("/api/products/${it.id}")
        }.toCreatedResponseEntity()
    }

    @GetMapping("/api/products/{id}")
    suspend fun findProductById(@PathVariable id: String): ResponseEntity<ApiResponse<ProductHttpResponse>> {
        return ProductHttpResponse(ecommerceClient.findProductById(id)).toOkResponseEntity()
    }
}
