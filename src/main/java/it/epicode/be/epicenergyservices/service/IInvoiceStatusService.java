package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.InvoiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IInvoiceStatusService {
    InvoiceStatus saveStatus(InvoiceStatus status);

    void deleteInvoiceStatus(Long id);

    List<InvoiceStatus> findAllInvoice();

    Page<InvoiceStatus> getAllInvoice(Pageable pagable);

    Optional<InvoiceStatus> findById(Long id);

    InvoiceStatus updateInvoiceStatus(InvoiceStatus s, Long id);
}
