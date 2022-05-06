package com.ndgndg91.grpcexampleclient.user

import com.ndgndg91.grpcexampleclient.config.EcommerceClient
import com.ndgndg91.grpcexampleclient.ext.toOkResponseEntity
import com.ndgndg91.grpcexampleclient.user.dto.CreateUserHttpRequest
import com.ndgndg91.grpcexampleclient.user.dto.UserHttpResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class UserController(val ecommerceClient: EcommerceClient) {

    @PostMapping("/api/users")
    suspend fun createUser(@RequestBody request: CreateUserHttpRequest): ResponseEntity<Void> {
        val userId = ecommerceClient.createUser(request.email, request.fullName)
        return ResponseEntity.created(URI.create("/api/users/${userId.id}")).build()
    }

    @GetMapping("/api/users/{id}")
    suspend fun findUserById(@PathVariable id: String): ResponseEntity<UserHttpResponse> {
        return ecommerceClient.findUserById(id).let {
            UserHttpResponse(it.id, it.email, it.fullName, it.createdAt.toBigInteger())
        }.toOkResponseEntity()
    }
}
