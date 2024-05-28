package com.hutech.ngay3c5.Entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Entity
public class Role {
    public Role(String role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String role_id;
    private String role_name;
    @OneToMany(mappedBy = "role")
    public List<User> userList;

}
