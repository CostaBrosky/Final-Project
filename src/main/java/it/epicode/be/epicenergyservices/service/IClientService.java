package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Address;
import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.model.Municipality;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IClientService {
    Client saveClient(Client c);

    void deleteClient(Long id);

    void updateClientBusinessName(String businessName, Long id);

    List<Client> findAllClient();

    Optional<Client> findByName(String name);

    Optional<Client> findByInsertionDate(LocalDateTime insertionDate);

    Optional<Client> findByLastContatctDate(LocalDateTime lastContatctDate);

    Optional<Client> findByOperationalHeadquarters(Municipality operationalHeadquarters_municipality);

    Page<Client> findByAmount(BigDecimal amount);

    Page<Client> filterByInsertionDate(LocalDateTime insertionDate);
}
