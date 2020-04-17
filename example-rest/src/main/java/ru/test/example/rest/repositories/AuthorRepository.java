package ru.test.example.rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.test.example.rest.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
