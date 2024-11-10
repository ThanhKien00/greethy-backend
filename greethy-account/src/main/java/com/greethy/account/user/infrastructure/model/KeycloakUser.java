package com.greethy.account.user.infrastructure.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class KeycloakUser {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean emailVerified;
    private boolean enabled;

}
