package com.example.demo.dog;

import jakarta.validation.constraints.NotEmpty;
import java.util.UUID;

public class Dog {
    private final UUID id;
    private String breed;
    private String name;

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
}
