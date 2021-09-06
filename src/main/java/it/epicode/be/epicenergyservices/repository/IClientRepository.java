package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Client;
import it.epicode.be.epicenergyservices.model.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;


public interface IClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByBusinessName(String businessName);

    Optional<Client> findByInsertionDate(LocalDateTime insertionDate);

    Optional<Client> findByLastContatctDate(LocalDateTime lastContatctDate);

    Optional<Client> findByOperationalHeadquarters_Municipality(Municipality operationalHeadquarters_municipality);

    @Modifying
    @Query("update Client set businessName =: businessName where id =: id")
    void updateClientBusinessNameById(@Param("businessName") String businessName, @Param("id") Long id);

}
