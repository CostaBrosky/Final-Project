package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province, Long> {
}
