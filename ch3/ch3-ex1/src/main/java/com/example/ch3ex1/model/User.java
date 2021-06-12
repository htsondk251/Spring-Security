package com.example.ch3ex1.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    @SequenceGenerator(name = "userIdSeq", sequenceName = "userIdSeq", allocationSize = 1)
    private Long id;

    private UUID userUuid;
    private String username;
    private String password;
    private String authority;

    public User(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.userUuid = UUID.randomUUID();
    }
}
