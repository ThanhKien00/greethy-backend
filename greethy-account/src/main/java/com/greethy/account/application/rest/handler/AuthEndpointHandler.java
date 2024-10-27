package com.greethy.account.application.rest.handler;

import com.greethy.account.application.rest.model.command.CreateAccount;
import com.greethy.account.application.rest.model.command.AuthenticateUser;
import com.greethy.account.application.rest.model.response.LoginResponse;
import com.greethy.account.domain.port.in.AuthService;
import com.greethy.core.model.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthEndpointHandler {

    private final ObjectValidator validator;
    private final AuthService authService;

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(AuthenticateUser.class)
                .doOnNext(validator::validate)
                .flatMap(authService::getToken)
                .map(response -> DataResponse.<LoginResponse>builder()
                        .data(response)
                        .message("successful login")
                        .code(1001))
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> logout(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> signup(ServerRequest request) {
        return request.bodyToMono(CreateAccount.class)
                .flatMap(command -> ServerResponse.ok().bodyValue(command));

    }

}
