package com.example.demo.dog;

import jakarta.validation.constraints.NotEmpty;
import java.util.UUID;

public class Dog {
    public String breed;
    public String name;
    public UUID id;

    public Dog(
        @NotEmpty
        String breed,
        @NotEmpty
        String name
    ) {
        this.id = UUID.randomUUID();
        this.breed = breed;
        this.name = name;
    }
}
