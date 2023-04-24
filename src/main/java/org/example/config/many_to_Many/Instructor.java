package org.example.config.many_to_Many;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(
            generator = "instructor_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "instructor_gen",
            sequenceName = "instructor_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String groupName;
    @ManyToMany
    private List<Student> students;
}
