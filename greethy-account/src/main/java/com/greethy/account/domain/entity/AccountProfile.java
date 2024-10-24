package com.greethy.account.domain.entity;

import com.greethy.account.domain.valueobject.Address;
import com.greethy.account.domain.valueobject.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class AccountProfile {

    private Long id;

    private String imageUrl;

    private Date dateOfBirth;

    private Gender gender;

    private String bio;

    private Address address;

    private Account account;

}
