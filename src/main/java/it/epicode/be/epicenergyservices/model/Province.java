package it.epicode.be.epicenergyservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String acronyms;

    private String region;
}
