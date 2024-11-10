package com.greethy.account.user.domain.entity;

import lombok.Data;

@Data
public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private boolean emailVerified;
    private boolean enabled;

}
