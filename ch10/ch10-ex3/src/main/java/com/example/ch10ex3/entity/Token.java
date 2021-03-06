package com.example.ch10ex3.entity;

import javax.persistence.*;

import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Token {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String identifier;
    private String token;
}
