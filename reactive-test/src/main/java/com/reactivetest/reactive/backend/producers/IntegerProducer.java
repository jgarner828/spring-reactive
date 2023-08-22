package com.reactivetest.reactive.backend.producers;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;

public class IntegerProducer {

    public Flux<Integer> createIntegerFlux() {
        return Flux.create(emitter -> {
            for(int i = 0; i < 100; i++) {
                emitter.next(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            emitter.complete();
        });
    }

}



