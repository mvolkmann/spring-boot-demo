package com.example.demo.dog;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DogTest {
    @Test
    public void canCreate() throws AssertionError {
        String breed = "Whippet";
        String name = "Comet";
        Dog dog = new Dog(breed, name);
        assertThat(dog.getBreed()).isEqualTo(breed);
        assertThat(dog.getName()).isEqualTo(name);
    }

    @Test
    public void throwsOnMissingBreed() throws AssertionError {
        String breed = "";
        String name = "Oscar";
        assertThrows(
            RuntimeException.class,
            () -> new Dog(breed, name),
            "Expected new Dog with empty breed to throw"
        );
    }
}
