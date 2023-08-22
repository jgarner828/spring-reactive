package com.reactivetest.reactive.backend.models;

import jdk.jfr.DataAmount;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "customer")
public class Customer {

    private String id;
    private String name;
    private int age;
}
