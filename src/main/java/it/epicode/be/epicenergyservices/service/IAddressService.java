package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService {
    Address saveAddress(Address a);

    void deleteAddress(Long id);

    List<Address> findAllAddress();

    Page<Address> getAddressByName(Pageable pageable);
}
