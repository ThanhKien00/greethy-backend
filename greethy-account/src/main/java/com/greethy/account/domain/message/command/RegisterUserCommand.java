package com.greethy.account.domain.message.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.lang.NonNull;

import java.util.UUID;

public record RegisterUserCommand(@TargetAggregateIdentifier UUID id,
                                  String email,
                                  String username,
                                  String password
) {
    public RegisterUserCommand(@NonNull UUID id,
                               @NonNull String email,
                               @NonNull String username,
                               @NonNull String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public RegisterUserCommand withId(@NonNull UUID id) {
        return new RegisterUserCommand(id, email(), username(), password());
    }

}
