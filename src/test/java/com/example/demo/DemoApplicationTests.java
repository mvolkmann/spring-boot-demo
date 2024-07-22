package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.example.demo.dog.Dog;

@SpringBootTest
class DemoApplicationTests {
	@Test
	void shouldGetDogs() {
		String url = "http://localhost:1919";
		WebTestClient client = WebTestClient.bindToServer().baseUrl(url).build();
		client.get().uri("/api/dog").exchange().expectStatus().isOk().expectBodyList(Dog.class);
	}
}
