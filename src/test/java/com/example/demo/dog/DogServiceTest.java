package com.example.demo.dog;

import java.util.Optional;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DogServiceTest {
    @Test
    public void shouldHandleCrud() throws Exception {
        DogService service = new InMemoryDogService();
        service.addDog("Whippet", "Comet");
        service.addDog("German Shorthaired Pointer", "Oscar");

        Dog[] dogs = service.getDogs();
        assertThat(dogs).isNotNull();
        assertThat(dogs).hasSize(2);
        assertThat(dogs[0].getName()).isEqualTo("Comet");
        assertThat(dogs[1].getName()).isEqualTo("Oscar");

        Dog dog = dogs[0];
        String id = dog.getId().toString();
        dog.setName("Fireball");
        service.updateDog(id, dog);
        Optional<Dog> updatedDog = service.getDog(id);
        assertThat(updatedDog.isPresent());
        assertThat(updatedDog.get().getName()).isEqualTo("Fireball"); 

        service.deleteDog(id);
        dogs = service.getDogs();
        assertThat(dogs).isNotNull();
        assertThat(dogs).hasSize(1);
        dog = dogs[0];
        assertThat(dog.getName()).isEqualTo("Oscar");
    }
}
