package com.greethy.account.infrastructure.database;

import com.greethy.account.infrastructure.database.model.AccountModel;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends R2dbcRepository<AccountModel, String> {
}
