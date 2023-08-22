package com.reactivetest.reactive.backend.controllers;
import com.reactivetest.reactive.backend.producers.IntegerProducer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController
public class MainController {

    private IntegerProducer producer;

public MainController() {
    this.producer = new IntegerProducer();
    };


    @GetMapping( name = "/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE )
    public Flux<Integer> objectLists() throws InterruptedException {


        return producer.createIntegerFlux();
    }
}
