package ru.test.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/get")
    public ResponseEntity<Iterable<Record>> records(
            @RequestParam(value = "limit", required = false) Integer limit,
            @PageableDefault(size = Integer.MAX_VALUE) Pageable page){

        if(limit != null){
            page = PageRequest.of(0,limit);
        }
        return ResponseEntity.ok().body(recordRepository.findAll(page).getContent());
    }

    @PostMapping("/create")
    public ResponseEntity<Record> createRecord(@RequestBody Record record){
        return ResponseEntity.ok().body(recordRepository.save(record));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deleteRecord(@PathVariable Integer id){
        return recordRepository.findById(id).map(record -> {
                    recordRepository.delete(record);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/update")
    public ResponseEntity<Record> updateRecord(@RequestBody Record record){
        return recordRepository.findById(record.getId())
                .map(r -> ResponseEntity.ok().body(recordRepository.save(r)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
