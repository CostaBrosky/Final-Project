package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.model.InvoiceStatus;
import it.epicode.be.epicenergyservices.service.IInvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/invoice-status")
public class InvoiceStatusController {

    @Autowired
    private IInvoiceStatusService invoiceStatusService;

    @PostMapping
    public ResponseEntity<?> saveInvoiceStatus(@RequestBody InvoiceStatus status) {
        return new ResponseEntity<>(invoiceStatusService.saveStatus(status), HttpStatus.CREATED);
    }

    @GetMapping("/n")
    public ResponseEntity<?> findAllInvoice() {
        return new ResponseEntity<>(invoiceStatusService.findAllInvoice(), HttpStatus.OK);
    }

    @GetMapping("/p")
    public ResponseEntity<Page<InvoiceStatus>> getAllInvoice(Pageable pageable) {
        return new ResponseEntity<>(invoiceStatusService.getAllInvoice(pageable), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInvoiceStatus(@PathVariable Long id) {
        invoiceStatusService.deleteInvoiceStatus(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<InvoiceStatus> updateInvoiceStatus(@RequestBody InvoiceStatus newStatus, @PathVariable Long id) {
        return new ResponseEntity<>(invoiceStatusService.updateInvoiceStatus(newStatus, id), HttpStatus.OK);
    }
}
