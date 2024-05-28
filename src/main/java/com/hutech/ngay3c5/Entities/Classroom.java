package com.hutech.ngay3c5.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Classroom {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_class;
    private String Name;
   /* @OneToMany(mappedBy = "classroom")
    private List<Student> studentList;*/

    public Classroom(String name, List<Student> studentList) {
        Name = name;
      /*  this.studentList = studentList;*/
    }
}
