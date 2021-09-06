package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMunicipalityRepository extends JpaRepository<Municipality, Long> {
}
