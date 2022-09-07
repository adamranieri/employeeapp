package dev.ranieri.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.ranieri.entities.Employee;
import dev.ranieri.exceptions.InsufficientPermissionException;
import dev.ranieri.exceptions.UnauthenticatedException;
import dev.ranieri.repos.EmployeeRepo;
import dev.ranieri.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin // for cors
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo; // bad practice to directly use repo

    @Autowired
    JwtService jwtService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(@RequestHeader("auth") String jwt){
        System.out.println(jwt);

        if(jwtService.validateJWT(jwt)){
            DecodedJWT decodedJWT = JWT.decode(jwt);// take it out of base64
            String role = decodedJWT.getClaim("role").asString();

            if(role.equals("admin")){
                return employeeRepo.findAll();
            }else{
                throw new InsufficientPermissionException();
            }

        }

       throw new UnauthenticatedException();
    }
}
