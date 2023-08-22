package com.reactivetest.reactive.backend.repositories.repositories;

import com.reactivetest.reactive.backend.models.Customer;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

    @Query("SELECT * FROM customer WHERE id = :id")
    Flux<Customer> findAllByid(String id);

}
