package com.ndgndg91.grpcexampleclient.product

import com.ndgndg91.grpcexampleclient.config.EcommerceClient
import com.ndgndg91.grpcexampleclient.product.dto.CreateProductHttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class ProductController(private val ecommerceClient: EcommerceClient){

    // TODO : implementation
    @PostMapping("/api/products")
    fun createProduct(@RequestBody request: CreateProductHttpRequest): ResponseEntity<Unit> {
        val id = ""
        return ResponseEntity.created(URI.create("/api/products/$id")).build()
    }

    // TODO : implementation
    @GetMapping("/api/products/{id}")
    fun findProductById(@PathVariable id: String): ResponseEntity<*> {
        return ResponseEntity.ok(null)
    }
}
