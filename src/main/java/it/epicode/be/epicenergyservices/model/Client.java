package it.epicode.be.epicenergyservices.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String businessName;

    @Column(unique = true, nullable = false)
    private String vatNumber;

    private String email;

    private LocalDateTime insertionDate;

    private LocalDate lastContatctDate;

    @Column(nullable = false)
    private String pec;

    private String phone;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactName;

    @Column(nullable = false)
    private String contactSurname;

    @Column(nullable = false)
    private String contactPhone;

    @OneToMany
    private List<Address> adress;

    @OneToMany
    private List<Invoices> invoices;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClientType type;
}