package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
