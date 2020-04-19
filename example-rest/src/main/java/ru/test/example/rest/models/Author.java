package ru.test.example.rest.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Record> records = new HashSet<>();

}
