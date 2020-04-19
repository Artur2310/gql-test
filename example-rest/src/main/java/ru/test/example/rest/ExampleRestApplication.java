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
        Author authorOne = Author.builder().name("One").age(18).build();
        Author authorTwo = Author.builder().name("Two").age(21).build();

        authorOne = authorRepository.save(authorOne);
        authorTwo = authorRepository.save(authorTwo);

        Record one = Record.builder().title("One").author(authorOne).description("One Description").build();
        Record two = Record.builder().title("Two").author(authorOne).description("Two Description").build();
        Record three = Record.builder().title("Three").author(authorOne).description("Three Description").build();
        Record four = Record.builder().title("Four").author(authorTwo).description("Four Description").build();
        Record five = Record.builder().title("Five").author(authorTwo).description("Five Description").build();

        recordRepository.saveAll(Arrays.asList(one, two, three, four, five));

    }
}
