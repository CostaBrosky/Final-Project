package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.InvoiceStatus;

import java.util.List;

public interface IInvoiceStatusService {
    InvoiceStatus saveStatus(InvoiceStatus status);

    void deleteInvoiceStatus(Long id);

    List<InvoiceStatus> findAllInvoice();
}
