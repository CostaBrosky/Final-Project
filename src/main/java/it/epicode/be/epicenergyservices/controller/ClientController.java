package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.data.ClientDto;
import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.service.IClientService;
import it.epicode.be.epicenergyservices.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private IMunicipalityService municipalityService;

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> insertClient(@RequestBody ClientDto cl) {
        Client c;
        try {
            c = cl.toClient(municipalityService);
            clientService.saveClient(c);
            return new ResponseEntity<ClientDto>(ClientDto.fromClient(c), HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllClient() {
        return new ResponseEntity<>(clientService.findAllClient(), HttpStatus.OK);
    }

    @GetMapping("/p")
    public ResponseEntity<Page<Client>> getByName(Pageable pageable) {
        return new ResponseEntity<>(clientService.getByName(pageable), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<?> getClientByName(@PathVariable String name) {
        clientService.findByName(name);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("edit-client/{businessName}/{id}")
    public ResponseEntity<?> updateClient(@PathVariable String businessName,@PathVariable Long id) {
        clientService.updateClientBusinessName(businessName, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client newStatus, @PathVariable Long id) {
        return new ResponseEntity<>(clientService.updateClient(newStatus, id), HttpStatus.OK);
    }

    @GetMapping("/between/{min}/{max}")
    public ResponseEntity<Page<Client>> findByFatturatoAnnualeGreatherThan(@PathVariable BigDecimal min, @PathVariable BigDecimal max, Pageable p) {
            Page<Client> risult = clientService.findByAmountBetween(min, max, p);
            if (risult.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(risult, HttpStatus.OK);
            }
    }

    @GetMapping("/contain/{name}")
    public ResponseEntity<Page<Client>> findByBusinessName(@PathVariable String name, Pageable pageable) {
        Page<Client> risult = clientService.findByBusinessNameContaining(name, pageable);
        if (risult.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(risult, HttpStatus.OK);
        }
    }

    @GetMapping("/date")
    public ResponseEntity<Page<Client>> findByInsertionDateBefore(@RequestBody LocalDateTime before, Pageable pageable) {
        Page<Client> risult = clientService.findByInsertionDateBefore(before, pageable);
        if (risult.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(risult, HttpStatus.OK);
        }
    }

    @GetMapping("/last-date")
    public ResponseEntity<Page<Client>> findByLastContatctDateBefore(@RequestBody LocalDateTime lastDate, Pageable p) {
            Page<Client> risultato = clientService.findByInsertionDateBefore(lastDate, p);
            if (risultato.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(risultato, HttpStatus.OK);
            }
    }

}
