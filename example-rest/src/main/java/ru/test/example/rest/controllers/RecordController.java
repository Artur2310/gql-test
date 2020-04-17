package ru.test.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.example.rest.models.Record;
import ru.test.example.rest.repositories.RecordRepository;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordRepository recordRepository;

    @GetMapping("/get/{id}")
    public ResponseEntity<Record> recordById(@PathVariable Integer id){
        return recordRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Record> createRecord(@RequestBody Record record){
        return ResponseEntity.ok().body(recordRepository.save(record));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity createRecord(@PathVariable Integer id){
        return recordRepository.findById(id).map(record -> {
                    recordRepository.delete(record);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
