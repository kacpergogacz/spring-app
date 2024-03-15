package org.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder,
                                     @Value("${isa.company.url}") String companyUrl,
                                     @Value("${isa.hardware.url}") String hardwareUrl,
                                     @Value("${isa.gateway.host}") String host) {
        return builder.routes()
                .route("company_route", r -> r
                        .path("/companies/**")
                        .uri(companyUrl))
                .route("hardware_route", r -> r
                        .path("/hardwares/**")
                        .uri(hardwareUrl))
                .route("company_id_route", r -> r
                        .path("/companies/{companyId}")
                        .uri(companyUrl))
                .route("hardware_id_route", r -> r
                        .path("/hardwares/{hardwareId}")
                        .uri(hardwareUrl))
                .route("fallback_route", r -> r
                        .path("/**")
                        .filters(f -> f.rewritePath("/api(?<remaining>.*)", "/$\\{remaining}"))
                        .uri(host))
                .build();
    }
}
