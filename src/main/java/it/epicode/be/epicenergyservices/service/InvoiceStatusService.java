package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.InvoiceStatus;
import it.epicode.be.epicenergyservices.repository.IInvoiceStatusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceStatusService implements IInvoiceStatusService {

    private final IInvoiceStatusRepository invoiceStatusRepository;

    public InvoiceStatusService(IInvoiceStatusRepository invoiceStatusRepository) {
        this.invoiceStatusRepository = invoiceStatusRepository;
    }

    @Override
    public InvoiceStatus saveStatus(InvoiceStatus status) {
        return invoiceStatusRepository.save(status);
    }

    @Override
    public void deleteInvoiceStatus(Long id) {
        invoiceStatusRepository.deleteById(id);
    }

    @Override
    public List<InvoiceStatus> findAllInvoice() {
        return invoiceStatusRepository.findAll();
    }

    @Override
    public Page<InvoiceStatus> getAllInvoice(Pageable pagable) {

        return invoiceStatusRepository.findAll(pagable);
    }
}
