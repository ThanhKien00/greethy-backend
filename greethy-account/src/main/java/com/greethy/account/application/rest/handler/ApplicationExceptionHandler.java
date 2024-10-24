package com.greethy.account.application.rest.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.function.Consumer;

@Component
public class ApplicationExceptionHandler {

    @Value("${spring.application.name}")
    private String serviceName;

    public Mono<ServerResponse> handleException(ServerWebInputException ex, ServerRequest request) {
        return handleException(ex, HttpStatus.BAD_REQUEST, request, problemDetail -> {
            problemDetail.setTitle("Invalid Input");
            problemDetail.setType(URI.create("http://" + serviceName + "/problems/invalid-input"));
        });
    }

    private Mono<ServerResponse> handleException(Exception ex,
                                                HttpStatus status,
                                                ServerRequest request,
                                                Consumer<ProblemDetail> consumer) {
        var problem = ProblemDetail.forStatus(status);
        problem.setInstance(URI.create(request.path()));
        problem.setDetail(ex.getMessage());
        System.out.println(ex.getMessage());
        consumer.accept(problem);
        return ServerResponse.status(status).bodyValue(problem);
    }

}
