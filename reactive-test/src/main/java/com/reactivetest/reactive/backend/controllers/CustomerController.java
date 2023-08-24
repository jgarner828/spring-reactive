package com.reactivetest.reactive.backend.controllers;

import com.reactivetest.reactive.backend.models.Customer;
import com.reactivetest.reactive.backend.repositories.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RestController
@Log4j2
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Customer> getCustomers() {
        return repository.findAll();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> addCustomer(@RequestBody Customer customer) {

        try {
            customer.setId(UUID.randomUUID().toString());
            return repository.save(customer);
        }
        catch (Exception e) {
            log.error("Failed to add customer", e);
            throw new RuntimeException("Failed to add customer" + e);
        }

    };

}
