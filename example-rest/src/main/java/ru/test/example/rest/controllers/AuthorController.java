package ru.test.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/get")
    public ResponseEntity<Iterable<Author>> authors(
            @RequestParam(value = "limit", required = false) Integer limit,
            @PageableDefault(size = Integer.MAX_VALUE) Pageable page){

        if(limit != null){
            page = PageRequest.of(0,limit);
        }
        return ResponseEntity.ok().body(authorRepository.findAll(page).getContent());
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
