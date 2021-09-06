package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.saveClient(client), HttpStatus.CREATED);
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

    @GetMapping("{name}")
    public ResponseEntity<?> getClientByName(@PathVariable String name) {
        clientService.findByName(name);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("edit-client/{businessName}{id}")
    public ResponseEntity<?> updateClient(@PathVariable String businessName,@PathVariable Long id) {
        clientService.updateClientBusinessName(businessName, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}