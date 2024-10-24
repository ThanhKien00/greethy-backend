package com.greethy.account.application.rest.model.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public record UserLoginCommand(@JsonProperty("username_or_email") @NotBlank(message = "bad-request.empty") String usernameOrEmail,
                               @JsonProperty("password") @NotBlank(message = "not blank") String password) {

    public UserLoginCommand(@NonNull String usernameOrEmail,
                            @NonNull String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

}
