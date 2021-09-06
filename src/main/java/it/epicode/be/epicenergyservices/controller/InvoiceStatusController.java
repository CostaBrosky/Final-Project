package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.model.InvoiceStatus;
import it.epicode.be.epicenergyservices.service.IInvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<?> getAllInvoice() {
        return new ResponseEntity<>(invoiceStatusService.findAllInvoice(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInvoiceStatus(@PathVariable Long id) {
        invoiceStatusService.deleteInvoiceStatus(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
