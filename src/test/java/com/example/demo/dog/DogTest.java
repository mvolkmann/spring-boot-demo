package com.example.demo.dog;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
// Other assertion functions in org.junit.jupiter.api.Assertions include:
// assertAll (for executables), assertIterableEquals, assertLinesMatch, and assertNull.

public class DogTest {
    @Test
    public void canCreate() throws AssertionError {
        String breed = "Whippet";
        String name = "Comet";
        Dog dog = new Dog(breed, name);
        assertThat(dog.getBreed()).isEqualTo(breed);
        assertEquals(name, dog.getName());
        assertFalse(dog.getName().isEmpty());
        assertNotEquals("Snoopy", dog.getName());
        assertNotNull(dog.getName());
        assertNotSame(breed, dog.getName());
        assertSame(name, dog.getName());
        assertTimeout(
                Duration.ofMillis(1),
                () -> new Dog(breed, name), // runs in same thread
                "creating a Dog object is too slow"
        );
        assertTimeoutPreemptively(
            Duration.ofMillis(1),
            () -> new Dog(breed, name), // runs in new thread
            "creating a Dog object is too slow"
        );
        assertTrue(dog.getName().length() > 4);
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

    @Test
    public void otherAssertions() throws AssertionError {
        String[] colors1 = {"red", "green", "blue"};
        String[] colors2 = {"red", "green", "blue"};
        assertArrayEquals(colors1, colors2);

        //fail("should never reach this line");
    }
}
