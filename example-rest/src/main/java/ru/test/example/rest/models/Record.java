package ru.test.example.rest.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Record {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

   /* @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Author author;*/
}
