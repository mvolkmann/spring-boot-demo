package com.example.demo.dog;

import java.util.UUID;

public class Dog {
    public String breed;
    public String name;
    public UUID id;

    public Dog(String breed, String name) {
        this.id = UUID.randomUUID();
        this.breed = breed;
        this.name = name;
    }
}

/* TODO: Why can't I use this instead of the code above?
public record Dog(
        // UUID id,
        String breed,
        String name
) {}
*/
