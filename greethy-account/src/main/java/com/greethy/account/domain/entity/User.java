package com.greethy.account.domain.entity;

import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class User {

    @AggregateIdentifier
    private String id;

}
