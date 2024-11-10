package com.greethy.account.user.application.rest.handler;

import com.greethy.account.user.application.rest.handler.dto.RegisterUserCommand;
import com.greethy.account.user.domain.service.AuthService;
import com.greethy.account.config.component.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class AuthEndpointHandler {

    private final AuthService authService;
    private final ObjectValidator validator;

    public Mono<ServerResponse> signup(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(RegisterUserCommand.class)
                .doOnNext(validator::validate)
                .flatMap(authService::signup)
                .transform(response -> ServerResponse.created(URI.create("")).build() );
    }

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(RegisterUserCommand.class)
                .doOnNext(validator::validate)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> logout(ServerRequest request) {
        return null;
    }


}
