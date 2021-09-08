package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Invoices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInvoicesService {
    Invoices saveInvoice(Invoices i);

    void deleteInvoices(Long id);

    List<Invoices> findAllInvoices();

    Page<Invoices> getInvoicesByName(Pageable pageable);

    Invoices updateInvoices(Invoices s, Long id);
}
