package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.model.Invoices;
import it.epicode.be.epicenergyservices.service.IInvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

    @Autowired
    private IInvoicesService invoicesService;

    @PostMapping
    public ResponseEntity<?> saveInvoices(@RequestBody Invoices invoices) {
        return new ResponseEntity<>(invoicesService.saveInvoice(invoices), HttpStatus.CREATED);
    }

    @GetMapping("/n")
    public ResponseEntity<?> getAllInvoice() {
        return new ResponseEntity<>(invoicesService.findAllInvoices(), HttpStatus.OK);
    }

    @GetMapping("/by-name")
    public ResponseEntity<Page<Invoices>> getInvoiceByName(Pageable pageable) {
        return new ResponseEntity<>(invoicesService.getInvoicesByName(pageable), HttpStatus.OK);
    }

    @DeleteMapping("{invoiceId}")
    public ResponseEntity<?> deleteInvoice(@PathVariable Long invoiceId) {
        invoicesService.deleteInvoices(invoiceId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Invoices> updateInvoices(@RequestBody Invoices newStatus, @PathVariable Long id) {
        return new ResponseEntity<>(invoicesService.updateInvoices(newStatus, id), HttpStatus.OK);
    }
}
