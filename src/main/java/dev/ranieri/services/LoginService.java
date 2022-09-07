package dev.ranieri.services;

import dev.ranieri.dtos.LoginCredentials;

public interface LoginService {


     String authenticateUser(LoginCredentials loginCredentials);
}
