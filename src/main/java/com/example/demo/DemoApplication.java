package com.example.demo;

//import org.opensearch.client.opensearch.OpenSearchClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	// The supported logging levels are fatal, error, warn, info, debug, and trace.
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    //private final OpenSearchClient openSearchClient;

	public static void main(String[] args) {
		logger.trace("This is a trace log message.");
		logger.debug("This is a debug log message.");
		logger.info("This is an info log message!");
		logger.warn("This is a warn log message.");
		logger.error("This is an error log message.");
		logger.info("{}, {}!", "Hello", "World");
		SpringApplication.run(DemoApplication.class, args);
	}

    /*
	DemoApplication(OpenSearchClient openSearchClient) {
		this.openSearchClient = openSearchClient;
		logger.info("openSearchClient = {}", openSearchClient);
	}
	*/
}
