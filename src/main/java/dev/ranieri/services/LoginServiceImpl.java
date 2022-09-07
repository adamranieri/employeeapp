package dev.ranieri.services;

import dev.ranieri.dtos.LoginCredentials;
import dev.ranieri.entities.Employee;
import dev.ranieri.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl  implements LoginService{

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    JwtService jwtService;

    @Override
    public String authenticateUser(LoginCredentials loginCredentials) {

        Employee employee = employeeRepo.findByUsername(loginCredentials.getUsername());

        if(!employee.getPassword().equals(loginCredentials.getPassword())){
            throw new RuntimeException("Password mismatch");
        }

        return jwtService.createJwtWithUsernameAndRole(employee.getUsername(),employee.getRole());
    }
}
