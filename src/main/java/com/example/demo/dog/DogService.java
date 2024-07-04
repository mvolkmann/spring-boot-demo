package com.example.demo.dog;

interface DogService {
    Dog addDog(String breed, String name);

    Dog getDog(String dogId);

    Dog[] getDogs();

    Dog updateDog(String dogId, Dog dog);

    boolean deleteDog(String dogId);
}
