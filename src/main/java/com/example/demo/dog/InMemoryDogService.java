package com.example.demo.dog;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class InMemoryDogService implements DogService {

    private final Map<UUID, Dog> dogMap = new LinkedHashMap<>();

    @Override
    public Dog addDog(final String breed, final String name) {
        try {
            Dog dog = new Dog(breed, name);
            dogMap.put(dog.getId(), dog);
            return dog;
        } catch (InstantiationException e) {
            return null;
        }
    }

    @Override
    public Optional<Dog> getDog(final String dogId) {
        return Optional.of(dogMap.get(UUID.fromString(dogId)));
    }

    @Override
    public Dog[] getDogs() {
        Collection<Dog> dogCollection = dogMap.values();
        return dogCollection.toArray(new Dog[0]);
    }

    @Override
    public Optional<Dog> updateDog(final String dogId, final Dog dog) {
        return Optional.ofNullable(
            dogMap.get(UUID.fromString(dogId))
        )
        .map(existingDog -> {
            existingDog.setBreed(dog.getBreed());
            existingDog.setName(dog.getName());
            return existingDog;
        });
    }

    @Override
    public boolean deleteDog(final String dogId) {
        Dog dog = dogMap.remove(UUID.fromString(dogId));
        return dog != null;
    }
}
