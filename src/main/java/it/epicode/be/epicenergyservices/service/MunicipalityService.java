package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Municipality;
import it.epicode.be.epicenergyservices.repository.IMunicipalityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MunicipalityService implements IMunicipalityService {

    private final IMunicipalityRepository municipalityRepository;

    public MunicipalityService(IMunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    @Override
    public Municipality saveMunicipality(Municipality p) {
        return municipalityRepository.save(p);
    }

    @Override
    public void deleteMunicipality(Long id) {
        municipalityRepository.deleteById(id);
    }

    @Override
    public Optional<Municipality> findById(Long id) {
        return municipalityRepository.findById(id);
    }

    @Override
    public Optional<Municipality> getMunicipalityById(Long pageable) {
        return municipalityRepository.findById(pageable);
    }

    @Override
    public Page<Municipality> getAllMunicipality(Pageable pageable) {
        return municipalityRepository.findAll(pageable);
    }

    @Override
    public Municipality updateMunicipality(Municipality p, Long id) {
        return municipalityRepository.findById(id)
                .map(muni -> {
                    muni.setId(p.getId());
                    muni.setIdMunicipality(p.getIdMunicipality());
                    muni.setName(p.getName());
                    muni.setProvince(p.getProvince());
                    return municipalityRepository.save(muni);
                })
                .orElseGet(() -> {
                    p.setId(id);
                    return municipalityRepository.save(p);
                });
    }

    @Override
    public Optional<Municipality> findByName(String municipality) {
        return municipalityRepository.findByName(municipality);
    }
}
