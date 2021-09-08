package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.repository.IClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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
    public Page<Client> getByName(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client updateClient(Client s, Long id) {
        return clientRepository.findById(id)
                .map( status -> {
                    status.setBusinessName(s.getBusinessName());
                    status.setVatNumber(s.getVatNumber());
                    status.setEmail(s.getEmail());
                    status.setPec(s.getPec());
                    status.setPhone(s.getPhone());
                    status.setContactEmail(s.getContactEmail());
                    status.setContactName(s.getContactName());
                    status.setContactSurname(s.getContactSurname());
                    status.setContactPhone(s.getContactPhone());
                    status.setType(s.getType());
                    status.setRegisteredOffice(s.getRegisteredOffice());
                    status.setOperationalHeadquarters(s.getOperationalHeadquarters());
                    return clientRepository.save(status);
                })
                .orElseGet(() -> {
                    s.setId(id);
                    return clientRepository.save(s);
                });
    }

    @Override
    public Page<Client> findByAmountBetween(BigDecimal min, BigDecimal max, Pageable p) {
        return clientRepository.findByAnnualRevenueBetween(min, max, p);
    }

    @Override
    public Page<Client> findByBusinessNameContaining(String name, Pageable pageable) {
        return clientRepository.findByBusinessNameContaining(name, pageable);
    }

    @Override
    public Page<Client> findByInsertionDateBefore(LocalDateTime before, Pageable pageable) {
        return clientRepository.findByInsertionDateBefore(before, pageable);
    }

    @Override
    public Page<Client> findByLastContatctDateBefore(LocalDateTime lastContact, Pageable pageable) {
        return clientRepository.findByInsertionDateBefore(lastContact, pageable);
    }

}
