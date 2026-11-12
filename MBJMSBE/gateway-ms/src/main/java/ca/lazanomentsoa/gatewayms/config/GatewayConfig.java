package ca.lazanomentsoa.gatewayms.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("etudiant-service", r -> r
                        .path("/api/etudiants/**")
                        .filters(f -> f
                                // 1. Supprime le header Origin pour que le MS croit que c'est une requête locale directe
                                .removeRequestHeader("Origin")
                                        .rewritePath("/api/etudiants(?<segment>/?.*)", "/api/etudiants${segment}")
                                // 2. Optionnel mais recommandé : supprime aussi le Host d'origine si le 403 persiste
                               // .removeRequestHeader("Host")
                        )
                       // .filters(f -> f.rewritePath("/api/(?<segment>/?.*)", "/${segment}"))
                        .uri("lb://ETUDIANT-MS")
                ).build();
    }
}
