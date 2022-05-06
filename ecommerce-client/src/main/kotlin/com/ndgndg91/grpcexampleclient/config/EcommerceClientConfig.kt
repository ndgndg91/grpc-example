package com.ndgndg91.grpcexampleclient.config

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:grpc.properties")
class EcommerceClientConfig {

    @Value("\${grpc.ecommerce.host}")
    private lateinit var ecommerceHost: String

    @Value("\${grpc.ecommerce.port}")
    private lateinit var ecommercePort: String

    @Bean
    fun managedChannel(): ManagedChannel {
        return ManagedChannelBuilder.forAddress(ecommerceHost, ecommercePort.toInt()).usePlaintext().build()
    }

    @Bean
    fun ecommerceClient(): EcommerceClient {
        return EcommerceClient(managedChannel())
    }

}

