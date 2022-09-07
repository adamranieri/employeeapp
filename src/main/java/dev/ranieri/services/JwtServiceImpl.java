package dev.ranieri.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService{


    private Algorithm algorithm = Algorithm.HMAC256("some string you must keep secret");

    @Override
    public String createJwtWithUsernameAndRole(String username, String role) {

        String jwt = JWT.create().withClaim("username",username).withClaim("role",role).sign(algorithm);

        return jwt;
    }

    @Override
    public boolean validateJWT(String jwt) {
        JWTVerifier verifier = JWT.require(algorithm).build();

        try{
            verifier.verify(jwt);// throws an exception if the JWT payload and signature do not match upt
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
