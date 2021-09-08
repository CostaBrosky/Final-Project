package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Province;
import it.epicode.be.epicenergyservices.repository.IProvinceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService{

    private final IProvinceRepository provinceRepository;

    public ProvinceService(IProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Province saveProvince(Province p) {
        return provinceRepository.save(p);
    }

    @Override
    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public Optional<Province> getProvinceById(Long pageable) {
        return provinceRepository.findById(pageable);
    }

    @Override
    public Page<Province> getAllProvince(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Province updateProvince(Province p, Long id) {
        return provinceRepository.findById(id)
                .map(province -> {
                    province.setAcronyms(p.getAcronyms());
                    province.setName(p.getName());
                    province.setRegion(p.getRegion());
                    return provinceRepository.save(province);
                })
                .orElseGet(() -> {
                    p.setId(id);
                    return provinceRepository.save(p);
                });
    }
}
