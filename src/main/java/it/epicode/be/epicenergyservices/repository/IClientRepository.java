package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;


public interface IClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByBusinessName(String businessName);

    Page<Client> findByAnnualRevenueBetween(BigDecimal min, BigDecimal max, Pageable pageable);

    Page<Client> findByBusinessNameContaining(String name, Pageable pageable);

    Page<Client> findByInsertionDateBefore(LocalDateTime insertionDate, Pageable pageable);

    Page<Client> findByLastContatctDateBefore(LocalDateTime lastContact, Pageable pageable);

    @Modifying
    @Query("update Client set businessName =: businessName where id =: id")
    void updateClientBusinessNameById(@Param("businessName") String businessName, @Param("id") Long id);

}
