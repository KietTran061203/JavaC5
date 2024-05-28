package com.hutech.ngay3c5.RequestEntities;

import com.hutech.ngay3c5.Entities.User;
import com.hutech.ngay3c5.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RequestCreateUser {
    private String id;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private boolean isdeleted;
    private Role role;
}
