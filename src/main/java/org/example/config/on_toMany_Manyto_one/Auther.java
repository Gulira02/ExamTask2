package org.example.config.on_toMany_Manyto_one;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "authors")
public class Auther {
    @Id
    @GeneratedValue(
            generator = "author_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "author_gen",
            sequenceName = "author_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "author_name")
    private String authorName;
    @OneToMany(mappedBy = "auther")
    private List<Book> books;
}
