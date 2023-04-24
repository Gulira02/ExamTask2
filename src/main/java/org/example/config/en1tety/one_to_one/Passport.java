package org.example.config.en1tety.one_to_one;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "passports")
@Getter
@Setter
@NoArgsConstructor
public class Passport {//Target Class
    @Id
    @GeneratedValue(
            generator = "passport_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "passport_gen",
            sequenceName = "passport_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String country;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @OneToOne(mappedBy = "passport")
    private Person person;
}

