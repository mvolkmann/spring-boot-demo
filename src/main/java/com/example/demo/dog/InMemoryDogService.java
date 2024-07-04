package com.example.demo.dog;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
//import org.springframework.sterotype.Service;

// @Service
@org.springframework.stereotype.Service
public class InMemoryDogService implements DogService {

    HashMap<UUID, Dog> dogMap = new HashMap<>();

    @Override
    public Dog addDog(String breed, String name) {
        Dog dog = new Dog(breed, name);
        dogMap.put(dog.id, dog);
        return dog;
    }

    @Override
    public Dog getDog(String dogId) {
        return dogMap.get(UUID.fromString(dogId));
    }

    @Override
    public Dog[] getDogs() {
        Collection<Dog> dogCollection = dogMap.values();
        Dog[] dogArray = dogCollection.toArray(new Dog[0]);
        return dogArray;
    }

    @Override
    public Dog updateDog(String dogId, Dog dog) {
        Dog existingDog = dogMap.get(UUID.fromString(dogId));
        existingDog.breed = dog.breed;
        existingDog.name = dog.name;
        return existingDog;
    }

    @Override
    public boolean deleteDog(String dogId) {
        Dog dog = dogMap.remove(UUID.fromString(dogId));
        return dog != null;
    }

}
