package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Invoices;
import it.epicode.be.epicenergyservices.repository.IInvoiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoicesService implements IInvoicesService {

    private final IInvoiceRepository invoiceRepository;

    public InvoicesService(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoices saveInvoice(Invoices i) {
        return invoiceRepository.save(i);
    }

    @Override
    public void deleteInvoices(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<Invoices> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Page<Invoices> getInvoicesByName(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }
}
