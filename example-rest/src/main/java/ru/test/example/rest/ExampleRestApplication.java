package ru.test.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.example.rest.models.Author;
import ru.test.example.rest.models.Record;
import ru.test.example.rest.repositories.AuthorRepository;
import ru.test.example.rest.repositories.RecordRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExampleRestApplication implements CommandLineRunner {

	@Autowired
	RecordRepository recordRepository;

	@Autowired
	AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExampleRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Author author = Author.builder().id(0).name("Test").age(18).build();
		author = authorRepository.save(author);

		Record one = Record.builder().title("One").author(author).description("One Description").build();
		Record two = Record.builder().title("Two").author(author).description("Two Description").build();
		Record three = Record.builder().title("Three").author(author).description("Three Description").build();

		recordRepository.saveAll(Arrays.asList(one,two, three));

	}
}
