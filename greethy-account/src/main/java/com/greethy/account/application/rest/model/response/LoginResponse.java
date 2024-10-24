package com.greethy.account.application.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    @JsonProperty(value = "id_token")
    private String idToken;

    @JsonProperty(value = "access_token")
    private String accessToken;

    @JsonProperty(value = "expires_in")
    private int expiresIn;

    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    @JsonProperty(value = "refresh_expires_in")
    private int refreshExpiresIn;

    @JsonProperty(value = "token_type")
    private String tokenType;

    @JsonProperty(value = "scope")
    private String scope;

}
