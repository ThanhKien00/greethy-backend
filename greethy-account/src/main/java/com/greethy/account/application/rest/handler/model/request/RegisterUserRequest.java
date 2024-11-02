package com.greethy.account.application.rest.handler.model.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserRequest(
        @NotBlank(message = "") String username,
        @NotBlank(message = "") String email,
        @NotBlank(message = "") String password
) {
}
