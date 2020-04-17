package ru.test.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.example.rest.models.Record;
import ru.test.example.rest.repositories.RecordRepository;

import java.util.Arrays;

@SpringBootApplication
public class ExampleRestApplication implements CommandLineRunner {

	@Autowired
	RecordRepository recordRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExampleRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Record one = Record.builder().title("One").description("One Description").build();
		Record two = Record.builder().title("Two").description("Two Description").build();
		Record three = Record.builder().title("Three").description("Three Description").build();

		recordRepository.saveAll(Arrays.asList(one,two, three));
	}
}
