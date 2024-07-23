package com.example.demo.dog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DogControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnListOfDogs() throws Exception {
        String url = "http://localhost:" + port + "/api/dog";
        ResponseEntity<Dog[]> response =
            restTemplate.getForEntity(url, Dog[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Dog[] dogs = response.getBody();
        assertThat(dogs).isNotNull();
        assertThat(dogs).hasSize(2);
        assertThat(dogs[0].getName()).isEqualTo("Oscar");
        assertThat(dogs[1].getName()).isEqualTo("Comet");
    }
}
