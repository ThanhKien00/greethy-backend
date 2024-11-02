package com.greethy.account.application.rest.handler;

import com.greethy.account.application.rest.handler.model.request.RegisterUserRequest;
import com.greethy.account.domain.message.command.RegisterUserCommand;
import com.greethy.account.domain.message.command.AuthenticateUser;
import com.greethy.account.infrastructure.config.component.RequestCommandMapper;
import com.greethy.account.infrastructure.config.validate.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthEndpointHandler {

    private final ObjectValidator validator;
    private final ReactorCommandGateway commandGateway;

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(AuthenticateUser.class)
                .doOnNext(validator::validate)
                .flatMap(commandGateway::send)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> signup(ServerRequest serverRequest) {
        UUID id = UUID.randomUUID();
        return serverRequest.bodyToMono(RegisterUserRequest.class)
                .doOnNext(validator::validate)
                .map(request -> new RegisterUserCommand(id, request.email(), request.username(), request.password()))
                .flatMap(commandGateway::send)
                .flatMap(command -> ServerResponse.ok().bodyValue(command));
    }

    public Mono<ServerResponse> logout(ServerRequest request) {
        return request.bodyToMono(RegisterUserCommand.class)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }


}
