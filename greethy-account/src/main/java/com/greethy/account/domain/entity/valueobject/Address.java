package com.greethy.account.domain.entity.valueobject;

public record Address (
        String country,
        String postalCode,
        String city,
        String street
) {}
