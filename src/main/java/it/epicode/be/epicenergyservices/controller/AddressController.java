package it.epicode.be.epicenergyservices.controller;

import it.epicode.be.epicenergyservices.model.Address;
import it.epicode.be.epicenergyservices.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping
    public ResponseEntity<?> saveAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllAddress() {
        return new ResponseEntity<>(addressService.findAllAddress(), HttpStatus.OK);
    }

    @GetMapping("/p")
    public ResponseEntity<Page<Address>> getAddressByName(Pageable pageable) {
        return new ResponseEntity<>(addressService.getAddressByName(pageable), HttpStatus.OK);
    }

    @DeleteMapping("{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address newStatus, @PathVariable Long id) {
        return new ResponseEntity<>(addressService.updateAddress(newStatus, id), HttpStatus.OK);
    }
}
