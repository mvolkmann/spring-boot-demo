package com.example.demo.dog;

import com.example.demo.DemoApplication;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Dog {
    private final UUID id;
    private String breed;
    private String name;
    private String color;

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    // This is only here to test ArchitectureTest.java serviceAccess rule.
    private final DogService service = new InMemoryDogService();

    public Dog(
        @NotEmpty
        String breed,
        @NotEmpty
        String name
    ) throws InstantiationException {
        if (breed.isEmpty()) throw new InstantiationException("Dog requires breed");
        this.id = UUID.randomUUID();
        this.breed = breed;
        this.name = name;

        // This is only here to test ArchitectureTest.java serviceAccess rule.
        logger.info(service.toString());
    }

    @JsonCreator
    Dog(
        UUID id,
        String breed,
        String name
    ) {
        this.id = id;
        this.breed = breed;
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }
}
