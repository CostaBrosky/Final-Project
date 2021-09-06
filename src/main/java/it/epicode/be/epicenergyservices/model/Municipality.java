package it.epicode.be.epicenergyservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Province province;
}