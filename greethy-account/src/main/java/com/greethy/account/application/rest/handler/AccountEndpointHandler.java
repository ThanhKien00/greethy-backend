package com.greethy.account.application.rest.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AccountEndpointHandler {

    public Mono<ServerResponse> getCurrentAccount(ServerRequest request) {
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .doOnNext(authentication -> System.out.println("Authentication: " + authentication.getAuthorities()))
                .map(Authentication::getPrincipal)
                .doOnNext(principal -> {
                    Jwt jwt = (Jwt) principal;
                    System.out.println(jwt.getSubject());
                })
                .doOnNext(principal -> log.info("security: Principal: {}", principal))
                .flatMap(_ -> ServerResponse.noContent().build());
    }

}
