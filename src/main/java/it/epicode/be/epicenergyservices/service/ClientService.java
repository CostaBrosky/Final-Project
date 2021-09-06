package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.model.Municipality;
import it.epicode.be.epicenergyservices.repository.IClientFilterRepository;
import it.epicode.be.epicenergyservices.repository.IClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService{

    private final IClientRepository clientRepository;

    private final IClientFilterRepository clientFilterRepository;

    public ClientService(IClientRepository clientRepository, IClientFilterRepository clientFilterRepository) {
        this.clientRepository = clientRepository;
        this.clientFilterRepository = clientFilterRepository;
    }

    @Override
    public Client saveClient(Client c) {
        c.setInsertionDate(LocalDateTime.now());

        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateClientBusinessName(String businessName, Long id) {
        clientRepository.updateClientBusinessNameById(businessName, id);
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findByName(String businesName) {
        return clientRepository.findClientByBusinessName(businesName);
    }

    @Override
    public Optional<Client> findByInsertionDate(LocalDateTime insertionDate) {
        return  clientRepository.findByInsertionDate(insertionDate);
    }

    @Override
    public Optional<Client> findByLastContatctDate(LocalDateTime lastContatctDate) {
        return clientRepository.findByLastContatctDate(lastContatctDate);
    }

    @Override
    public Optional<Client> findByOperationalHeadquarters(Municipality operationalHeadquarters_municipality) {
        return clientRepository.findByOperationalHeadquarters_Municipality(operationalHeadquarters_municipality);
    }

    @Override
    public Page<Client> findByAmount(BigDecimal amount) {
        return clientFilterRepository.findAllByInvoices(amount);
    }

    @Override
    public Page<Client> filterByInsertionDate(LocalDateTime insertionDate) {
        Pageable first = PageRequest.of(0,1000);
        return clientFilterRepository.findByInsertionDate(insertionDate, first);
    }
}
