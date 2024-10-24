package com.greethy.account.domain.port.in;

import com.greethy.account.application.rest.model.command.UserLoginCommand;
import com.greethy.account.application.rest.model.response.LoginResponse;
import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<LoginResponse> getToken(UserLoginCommand command);

}
