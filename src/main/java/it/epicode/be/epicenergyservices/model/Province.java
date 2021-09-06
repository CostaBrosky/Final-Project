package it.epicode.be.epicenergyservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String acronyms;

    @Column(nullable = false)
    private String region;
}
