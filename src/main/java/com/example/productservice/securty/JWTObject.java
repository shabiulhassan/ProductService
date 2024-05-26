package com.example.productservice.securty;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class JWTObject {
    private String email;
    private Long userId;
    private Date expriryAt;
    private Date createdAt;
    private List<Role> roles;

}
