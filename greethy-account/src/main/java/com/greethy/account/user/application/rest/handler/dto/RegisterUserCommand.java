package com.greethy.account.user.application.rest.handler.dto;

public record RegisterUserCommand (String username, String email, String password) {
}
