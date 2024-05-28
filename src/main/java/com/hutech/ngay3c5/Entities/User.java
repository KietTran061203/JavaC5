package com.hutech.ngay3c5.Entities;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private boolean isdeleted;
    @ManyToOne
    @JoinColumn(name = "id_role")
    public Role role;
    public User(String id, String username, String password, String email, String firstname, String lastname, boolean isdeleted, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isdeleted = isdeleted;
        this.role = role;
    }

    public User() {

    }
}
