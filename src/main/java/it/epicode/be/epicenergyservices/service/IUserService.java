package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.User;

import java.util.Optional;

public interface IUserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
