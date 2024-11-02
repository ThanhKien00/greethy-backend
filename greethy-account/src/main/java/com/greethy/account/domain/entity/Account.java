package com.greethy.account.domain.entity;

import com.greethy.account.domain.entity.valueobject.AccountStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.ZonedDateTime;

@Data
@Aggregate
@NoArgsConstructor
public class Account {

    @AggregateIdentifier
    private String id;
    private String phoneNumber;
    private String image;
    private AccountStatus status;
    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;
    private String createdBy;
    private String modifiedBy;
    private AccountProfile profile;

}
