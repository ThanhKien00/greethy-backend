package com.greethy.account.domain.entity.event;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AccountCreated {
    private String id;
    private String userId;

}
