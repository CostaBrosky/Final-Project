package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMunicipalityRepository extends JpaRepository<Municipality, Long> {

    Optional<Municipality> findByName(String nome);
}
