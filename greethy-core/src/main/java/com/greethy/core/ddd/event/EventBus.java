package com.greethy.core.ddd.event;

import reactor.core.publisher.Mono;

public interface EventBus {

    Mono<Void> publish(Event event);

}
