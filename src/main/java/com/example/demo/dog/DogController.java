package com.example.demo.dog;

import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/dog") // provides base URL path for all the endpoints defined here
public class DogController {

    private final DogService service;

    // The object passed in will be an instance of InMemoryDogService.
    public DogController(DogService service) {
        this.service = service;
        //service.addDog("Treeing Walker Coonhound", "Maisey");
        //service.addDog("Native American Indian Dog", "Ramsay");
        service.addDog("German Shorthaired Pointer", "Oscar");
        service.addDog("Whippet", "Comet");
    }

    @GetMapping("")
    public Dog[] getDogs() {
        return service.getDogs();
    }

    @GetMapping("/{dogId}")
    public ResponseEntity<Dog> getDog(@PathVariable String dogId) {
        Optional<Dog> dog = service.getDog(dogId);
        return new ResponseEntity<>(
            dog.orElse(null),
            dog.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dog createDog(@Valid @RequestBody Dog dog) {
        return service.addDog(dog.getBreed(), dog.getName());
    }

    @PutMapping("/{dogId}")
    public ResponseEntity<Dog> updateDog(@PathVariable String dogId, @RequestBody Dog dog) {
        return service.updateDog(dogId, dog)
            .map(optionalDog -> new ResponseEntity<>(optionalDog, HttpStatus.OK))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{dogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteDog(@PathVariable String dogId) {
        boolean present = service.deleteDog(dogId);
        return new ResponseEntity<>(null, present ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
