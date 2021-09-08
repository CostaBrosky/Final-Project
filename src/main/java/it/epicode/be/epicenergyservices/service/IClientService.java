package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.model.Municipality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    
    Page<Client> getByName(Pageable pageable);

    Client updateClient(Client s, Long id);

    Page<Client> findByAmountBetween(BigDecimal min, BigDecimal max, Pageable p);

    Page<Client> findByBusinessNameContaining(String name, Pageable pageable);

    Page<Client> findByInsertionDateBefore(LocalDateTime before, Pageable pageable);

    Page<Client> findByLastContatctDateBefore(LocalDateTime lastContact, Pageable pageable);
}
