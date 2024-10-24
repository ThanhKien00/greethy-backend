package com.greethy.account.infrastructure.adapter.webclient;

import com.greethy.account.domain.port.out.UserPort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class KeycloakClient implements UserPort {

    private final WebClient keycloakClient = WebClient.builder()

            .build();



}
