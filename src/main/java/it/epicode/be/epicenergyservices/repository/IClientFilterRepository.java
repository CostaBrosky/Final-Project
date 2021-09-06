package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IClientFilterRepository extends PagingAndSortingRepository<Client, Long> {
//
//    Page<Client> findAllByInvoices(@Param("amount")BigDecimal amount);
//
//    Page<Client> findByInsertionDate(LocalDateTime insertionDate, Pageable pageable);
}
