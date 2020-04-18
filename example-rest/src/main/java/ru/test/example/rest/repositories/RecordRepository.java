package ru.test.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.test.example.rest.models.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
}
