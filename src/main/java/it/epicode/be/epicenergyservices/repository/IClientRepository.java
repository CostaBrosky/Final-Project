package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
