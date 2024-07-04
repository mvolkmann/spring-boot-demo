package com.example.demo.dog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dog") // provides base URL path for all the endpoints defined here
public class DogController {

    private DogService service;

    // The object passed in will be an instance of InMemoryDogService.
    public DogController(DogService service) {
        this.service = service;
        service.addDog("Whippet", "Comet");
        service.addDog("German Shorthaired Pointer", "Oscar");
    }

    @GetMapping("")
    public Dog[] getDogs() {
        return service.getDogs();
    }

    @GetMapping("/{dogId}")
    public ResponseEntity<Dog> getDog(@PathVariable String dogId) {
        Dog dog = service.getDog(dogId);
        return new ResponseEntity<Dog>(dog, dog == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PostMapping("")
    public Dog createDog(@RequestBody Dog dog) {
        return service.addDog(dog.breed, dog.name);
    }

    @PutMapping("/{dogId}")
    public Dog updateDog(@PathVariable String dogId, @RequestBody Dog dog) {
        return service.updateDog(dogId, dog);
    }

    @DeleteMapping("/{dogId}")
    public ResponseEntity<Void> deleteDog(@PathVariable String dogId) {
        boolean present = service.deleteDog(dogId);
        return new ResponseEntity<>(null, present ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
