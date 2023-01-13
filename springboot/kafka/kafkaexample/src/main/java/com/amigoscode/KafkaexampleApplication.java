package com.amigoscode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.stream.IntStream;

@SpringBootApplication
public class KafkaexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaexampleApplication.class, args);
	}

/*
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			IntStream.range(0, 10_000).forEach( e -> kafkaTemplate.send("amigoscode", "hello kafka " + e));
		};
	}

 */
}
