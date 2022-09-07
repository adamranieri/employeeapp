package dev.ranieri.services;


public interface JwtService {

    String createJwtWithUsernameAndRole(String username, String role);

    boolean validateJWT(String jwt);
}
