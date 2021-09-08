package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Municipality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IMunicipalityService {
    Municipality saveMunicipality(Municipality p);

    void deleteMunicipality(Long id);

    Optional<Municipality> findById(Long id);

    Optional<Municipality> getMunicipalityById(Long pageable);

    Page<Municipality> getAllMunicipality(Pageable pageable);

    Municipality updateMunicipality(Municipality p, Long id);

    Optional<Municipality> findByName(String municipality);
}
