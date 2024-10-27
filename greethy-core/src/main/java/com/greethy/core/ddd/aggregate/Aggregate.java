package com.greethy.core.ddd.aggregate;

import com.greethy.core.ddd.event.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Aggregate {

    String aggregateId();

    Flux<Event> aggregateEvents();

    Mono<Void> routeEvents();

}
