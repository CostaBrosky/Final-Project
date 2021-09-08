package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProvinceService {
    Province saveProvince(Province p);

    void deleteProvince(Long id);

    Optional<Province> findById(Long id);

    Optional<Province> getProvinceById(Long pageable);

    Page<Province> getAllProvince(Pageable pageable);

    Province updateProvince(Province p, Long id);
}
