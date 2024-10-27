package com.greethy.core.ddd.aggregate;


import com.greethy.core.ddd.event.Event;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Data
@Slf4j
@NoArgsConstructor
public abstract class AggregateRoot implements Aggregate {

    protected String aggregateId;
    protected String aggregateType;
    protected long version;

    protected Sinks.Many<Event> aggregateEventsSink = Sinks.many().multicast().onBackpressureBuffer();
    protected Flux<Event> $aggregateEvents = aggregateEventsSink.asFlux()
            .doOnNext(event -> log.debug("Event: {}", event))
            .publish().autoConnect();

    @Override
    public String aggregateId() {
        return aggregateId;
    }

}
