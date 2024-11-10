package com.greethy.account.profile.infrastructure.mysql;

import com.greethy.account.profile.infrastructure.mysql.model.AccountModel;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends R2dbcRepository<AccountModel, String> {
}
