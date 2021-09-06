package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceStatusRepository extends JpaRepository<InvoiceStatus, Long> {
}
