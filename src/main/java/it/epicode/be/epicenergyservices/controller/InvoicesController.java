package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.data.InvoiceDto;
import it.epicode.be.epicenergyservices.model.Invoices;
import it.epicode.be.epicenergyservices.service.IInvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

    @Autowired
    private IInvoicesService invoicesService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> inserisciFattura(@RequestBody InvoiceDto fDto) {
        Invoices f = fDto.toInvoices();
        invoicesService.saveInvoice(f);
        return new ResponseEntity<>(InvoiceDto.fromInvoice(f),HttpStatus.CREATED);
    }

    @GetMapping("/n")
    public ResponseEntity<?> getAllInvoice() {
        return new ResponseEntity<>(invoicesService.findAllInvoices(), HttpStatus.OK);
    }

    @GetMapping("/{year}")
    public ResponseEntity<Page<Invoices>> getInvoiceByYear(@PathVariable Integer year,  Pageable pageable) {
        return new ResponseEntity<>(invoicesService.getInvoicesByYear(year, pageable), HttpStatus.OK);
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<?> deleteInvoice(@PathVariable Long invoiceId) {
        invoicesService.deleteInvoices(invoiceId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Invoices> updateInvoices(@RequestBody Invoices newStatus, @PathVariable Long id) {
        return new ResponseEntity<>(invoicesService.updateInvoices(newStatus, id), HttpStatus.OK);
    }
}
