package ru.test.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.example.rest.models.Author;
import ru.test.example.rest.repositories.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/get/{id}")
    public ResponseEntity<Author> authorById(@PathVariable Integer id) {
        return authorRepository.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author Author) {
        return ResponseEntity.ok().body(authorRepository.save(Author));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Integer id) {
        return authorRepository.findById(id).map(Author -> {
                        authorRepository.delete(Author);
                        return ResponseEntity.ok().build();
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
