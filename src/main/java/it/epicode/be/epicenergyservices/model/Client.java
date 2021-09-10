package it.epicode.be.epicenergyservices.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessName;

    private String vatNumber;

    private String email;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime insertionDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime lastContatctDate;

    private String pec;

    private String phone;

    private String contactEmail;

    private String contactName;

    private String contactSurname;

    private String contactPhone;

    private BigDecimal annualRevenue;

    @Enumerated(EnumType.STRING)
    private ClientType type;

    @OneToMany
    private List<Invoices> invoices = new ArrayList<>();

    @OneToOne
    private Address registeredOffice;

    @OneToOne
    private Address operationalHeadquarters;
}