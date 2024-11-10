package com.greethy.account.user.application.rest;

import com.greethy.account.user.application.rest.handler.AuthEndpointHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@RequiredArgsConstructor
public class AuthEndpointsRouter {

    private final AuthEndpointHandler authEndpointHandler;

    @Bean
    public RouterFunction<ServerResponse> authEndpoints() {
        return RouterFunctions.route()
                .path("/v0/auth", builder -> builder
                        .POST("/signup", accept(MediaType.APPLICATION_JSON), authEndpointHandler::signup)
                        .POST("/login", accept(MediaType.APPLICATION_JSON), authEndpointHandler::login)
                        .POST("/logout", accept(MediaType.APPLICATION_JSON), authEndpointHandler::logout))
                .build();
    }

}
