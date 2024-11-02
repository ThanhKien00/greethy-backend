package com.greethy.account.domain.port.in;

import com.greethy.account.domain.message.command.AuthenticateUser;
import com.greethy.account.application.rest.handler.model.response.LoginResponse;
import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<LoginResponse> getToken(AuthenticateUser command);

}
