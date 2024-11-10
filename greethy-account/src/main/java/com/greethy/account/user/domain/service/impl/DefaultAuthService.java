package com.greethy.account.user.domain.service.impl;

import com.greethy.account.user.application.rest.handler.dto.RegisterUserCommand;
import com.greethy.account.user.domain.service.AuthService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DefaultAuthService implements AuthService {

    @Override
    public Mono<Void> signup(RegisterUserCommand command) {

        return null;
    }

}
