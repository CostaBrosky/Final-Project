package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Address;
import it.epicode.be.epicenergyservices.repository.IAddressRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Address> findById (Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address updateAddress(Address s, Long id) {
        return addressRepository.findById(id)
                .map( status -> {
                    status.setStreet(s.getStreet());
                    status.setCivic(s.getCivic());
                    status.setLocality(s.getLocality());
                    status.setPostalCode(s.getPostalCode());
                    status.setMunicipality(s.getMunicipality());
                    return addressRepository.save(status);
                })
                .orElseGet(() -> {
                    s.setId(id);
                    return addressRepository.save(s);
                });
    }
}
