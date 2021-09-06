package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<Invoices, Long> {
}
