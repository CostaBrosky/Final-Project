package it.epicode.be.epicenergyservices.service;

import it.epicode.be.epicenergyservices.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
