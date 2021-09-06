package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInvoiceStatusRepository extends JpaRepository<InvoiceStatus, Long> {

}
