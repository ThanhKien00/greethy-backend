package com.greethy.account.domain.entity;

import com.greethy.account.domain.entity.valueobject.AccountStatus;
import com.greethy.account.domain.entity.valueobject.Gender;
import com.greethy.core.ddd.aggregate.AggregateRoot;
import com.greethy.core.ddd.event.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Account extends AggregateRoot {

    private String id;
    private String userId;
    private String image;
    private Date dateOfBirth;
    private Gender gender;
    private AccountStatus status;
    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;
    private String createdBy;
    private String modifiedBy;
    private AccountProfile profile;

    public Flux<Event> aggregateEvents() {
        return $aggregateEvents.cast(Event.class);
    }

    @Override
    public Mono<Void> routeEvents() {
        return null;
    }

}
