package com.example.apigateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de rutas para el API Gateway.
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Rutas para MS-Customer
                .route("customer-service", r -> r.path("/customers/**")
                        .uri("lb://ms-customer"))

                // Rutas para MS-Account
                .route("account-service", r -> r.path("/accounts/**")
                        .uri("lb://ms-account"))

                // Rutas para MS-Transaction
                .route("transaction-service", r -> r.path("/transactions/**")
                        .uri("lb://ms-transaction"))

                // Rutas para MS-Credit
                .route("credit-service", r -> r.path("/credits/**")
                        .uri("lb://ms-credit"))

                // Rutas para MS-Credit-Card
                .route("credit-card-service", r -> r.path("/credit-cards/**")
                        .uri("lb://ms-credit-card"))

                .build();
    }
}