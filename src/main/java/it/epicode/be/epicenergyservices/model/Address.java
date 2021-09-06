package it.epicode.be.epicenergyservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String civic;

    private String locality;

    @Column(nullable = false)
    private int postalCode;

    @OneToOne
    private Municipality municipality;
}
