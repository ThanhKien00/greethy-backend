package com.greethy.account.application.rest;

import com.greethy.account.application.rest.handler.AccountEndpointHandler;
import com.greethy.account.application.rest.handler.AuthEndpointHandler;
import com.greethy.account.application.rest.handler.ApplicationExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@RequiredArgsConstructor
public class EndpointsRouter {

    private final AuthEndpointHandler authEndpointHandler;
    private final AccountEndpointHandler accountEndpointHandler;
    private final ApplicationExceptionHandler exceptionHandler;

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions.route()
                .path("/v0/auth", builder -> builder
                        .POST("/login", accept(MediaType.APPLICATION_JSON), authEndpointHandler::login)
                        .POST("/signup", accept(MediaType.APPLICATION_JSON), authEndpointHandler::signup)
                        .POST("/logout", accept(MediaType.APPLICATION_JSON), authEndpointHandler::logout)
                        .onError(ServerWebInputException.class, exceptionHandler::handleException))
                .path("/v0/me", builder -> builder
                        .GET("", accept(MediaType.APPLICATION_JSON), accountEndpointHandler::getCurrentAccount)
                        .PUT("", accept(MediaType.APPLICATION_JSON), accountEndpointHandler::updateCurrentAccountProfile)
                        .build())
                .build();
    }

}
