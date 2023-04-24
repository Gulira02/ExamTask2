package org.example.config.en1tety.one_to_one;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
public class Person {// Source Class
    @Id
    @GeneratedValue(
            generator = "person_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "person_gen",
            sequenceName = "person_seq",
            allocationSize = 1)
    private Long id;
    private Long INN;
    @OneToOne
    private Passport passport;

}
