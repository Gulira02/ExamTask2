package org.example.config.on_toMany_Manyto_one;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(
            generator = "book_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "book_gen",
            sequenceName = "book_seq",
            allocationSize = 1)
    private Long id;
    private String bookName;
    @ManyToOne
    private Auther auther;
}
