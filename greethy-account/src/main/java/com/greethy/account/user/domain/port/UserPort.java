package com.greethy.account.user.domain.port;

import reactor.core.publisher.Mono;

public interface UserPort {

    Mono<Boolean> exists(String username);

    Mono<Boolean> exists(String username, String email);

}
