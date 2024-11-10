package com.greethy.account.profile.domain.valueobject;

public record Address(String country,
                      String city,
                      String district,
                      String street,
                      String detail) {

}
