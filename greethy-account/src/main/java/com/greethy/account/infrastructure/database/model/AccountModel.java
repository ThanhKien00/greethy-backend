package com.greethy.account.infrastructure.database.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Table("accounts")
public class AccountModel {

    private String id;

    @Column("user_id")
    private String userId;

    private String image;

    @Column("date_of_birth")
    private Date dateOfBirth;

    private String gender;

    private String status;

    @Column("created_at")
    private ZonedDateTime createdAt;

    @Column("modified_at")
    private ZonedDateTime modifiedAt;

    @Column("created_by")
    private String createdBy;

    @Column("modified_by")
    private String modifiedBy;

}
