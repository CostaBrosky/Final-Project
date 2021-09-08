package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    Address saveAddress(Address a);

    void deleteAddress(Long id);

    List<Address> findAllAddress();

    Page<Address> getAddressByName(Pageable pageable);

    Optional<Address> findById(Long id);

    Address updateAddress(Address s, Long id);
}
