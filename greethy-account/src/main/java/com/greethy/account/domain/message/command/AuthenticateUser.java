package com.greethy.account.domain.message.command;

import org.springframework.lang.NonNull;

public record AuthenticateUser(
        String usernameOrEmail,
        String password
) {

    public AuthenticateUser(@NonNull String usernameOrEmail,
                            @NonNull String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

}
