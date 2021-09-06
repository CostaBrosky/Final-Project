package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Address;
import it.epicode.be.epicenergyservices.repository.IAddressRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {

    private final IAddressRepository addressRepository;

    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address a) {
        return addressRepository.save(a);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Page<Address> getAddressByName(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }
}
