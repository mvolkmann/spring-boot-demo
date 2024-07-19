package com.example.opensearch;

//import com.objectcomputing.experiment.zeroetl.aws.AwsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.HttpHost;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import(AwsConfig.class)
@EnableConfigurationProperties(OpenSearchProperties.class)
public class OpenSearchConfig {
	@Bean
	OpenSearchClient openSearchClient(OpenSearchTransport openSearchTransport) {
		return new OpenSearchClient(openSearchTransport);
	}

	@Bean
	OpenSearchTransport openSearchTransport(OpenSearchProperties openSearchProperties, ObjectMapper objectMapper) {
		var httpHost = new HttpHost(
				openSearchProperties.endpoint().getScheme(),
				openSearchProperties.endpoint().getHost(),
				openSearchProperties.endpoint().getPort()
		);

		return ApacheHttpClient5TransportBuilder.builder(httpHost)
				.setMapper(new JacksonJsonpMapper(objectMapper))
				.setOptions(TransportOptions.builder().build())
				.build();
	}
}