package com.example.demo.dog;

import java.util.Optional;

interface DogService {
    Dog addDog(String breed, String name);

    Optional<Dog> getDog(String dogId);

    Dog[] getDogs();

    Dog updateDog(String dogId, Dog dog);

    boolean deleteDog(String dogId);
}
