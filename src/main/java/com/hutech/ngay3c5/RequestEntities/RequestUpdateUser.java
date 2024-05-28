package com.hutech.ngay3c5.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateUser {
    private String id;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private boolean isdeleted;
}
