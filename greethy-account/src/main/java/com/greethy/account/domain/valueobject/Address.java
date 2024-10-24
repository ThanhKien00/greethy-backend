package com.greethy.account.domain.valueobject;

public record Address (
        String country,
        String postalCode,
        String city,
        String street
) {}
