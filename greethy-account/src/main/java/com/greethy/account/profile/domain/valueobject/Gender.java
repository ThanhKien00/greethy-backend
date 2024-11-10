package com.greethy.account.profile.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("Male", 0),
    FEMALE ("Female", 1),
    OTHER ("Other", 2);

    private final String displayName;
    private final int value;


}
