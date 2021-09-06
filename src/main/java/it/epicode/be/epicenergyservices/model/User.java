package it.epicode.be.epicenergyservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String email;

    private String password;

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String token;
}
