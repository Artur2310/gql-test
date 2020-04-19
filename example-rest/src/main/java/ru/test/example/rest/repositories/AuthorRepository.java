package ru.test.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.example.rest.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
