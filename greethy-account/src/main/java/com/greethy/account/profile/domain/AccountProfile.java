package com.greethy.account.profile.domain;

import com.greethy.account.profile.domain.valueobject.Address;
import com.greethy.account.profile.domain.valueobject.BodyIndex;
import com.greethy.account.profile.domain.valueobject.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountProfile {

    private String image;
    private String displayName;
    private String description;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Address address;
    private BodyIndex bodyIndex;

}
