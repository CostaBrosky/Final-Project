package it.epicode.be.epicenergyservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idProvince;

    private Long idMunicipality;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Province province;
}