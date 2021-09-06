package it.epicode.be.epicenergyservices.repository;

import it.epicode.be.epicenergyservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
