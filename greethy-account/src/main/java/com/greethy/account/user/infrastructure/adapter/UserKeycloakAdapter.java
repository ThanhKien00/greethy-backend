package com.greethy.account.user.infrastructure.adapter;

import com.greethy.account.config.security.keycloak.KeycloakProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class UserKeycloakAdapter {

    private final KeycloakProperties keycloakProperties;
    private final WebClient.Builder webClientBuilder;

    public Mono<String> getUsers() {
        String urlPath = "admin/realms/" + keycloakProperties.getRealm() + "/users";
        return this.webClientBuilder
                .baseUrl(keycloakProperties.getUrl())
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(urlPath)
                        .queryParam("exact", false)
                        .build())
                .retrieve().bodyToMono(String.class);
    }
}
