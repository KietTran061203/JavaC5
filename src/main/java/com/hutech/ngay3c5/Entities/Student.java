package com.hutech.ngay3c5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    @Transient
    private int age;
    @Column(nullable = false)
    private String password;
    /*@ManyToOne
    @JoinColumn(name = "id_class")
    private Classroom classroom;*/

    public Student(String firstName, String lastName, String email, Date dateOfBirth, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.age = (new Date()).getYear() - dateOfBirth.getYear();
    }
}
